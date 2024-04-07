package ru.vtb.toropov.limit.service;

import ru.vtb.toropov.limit.dtos.PaymentDto;
import ru.vtb.toropov.limit.model.UserLimit;
import ru.vtb.toropov.limit.repository.UserLimitRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * UserService.
 *
 * @author DToropov
 */
@Service
public class UserLimitService {

  private UserLimitRepository userLimitRepository;

  @Value("${limit-calculation.enabled}")
  private Boolean enabled = false;

  @Value("${limit-calculation.value-limit}")
  private BigDecimal valueLimit = BigDecimal.valueOf(0);


  @Autowired
  public void setUserLimitRepository(UserLimitRepository userLimitRepository) {
    this.userLimitRepository = userLimitRepository;
  }

  public Optional<UserLimit> findById(Long id) {

    if (userLimitRepository.findById(id).isEmpty()) {
      UserLimit userLimit = new UserLimit(id, "", valueLimit);
      userLimitRepository.save(userLimit);
    }
    return userLimitRepository.findById(id);
  }

  public void makePayment(Long userId, PaymentDto request) {
    Optional<UserLimit> userLimit = this.findById(userId);
    if (userLimit.isEmpty()) {
      return;
    }
    userLimit.get().setValueLimit(userLimit.get().getValueLimit().subtract(request.getAmount()));
    userLimitRepository.save(userLimit.get());
  }

  public void rollbackPayment(Long userId, PaymentDto request) {
    Optional<UserLimit> userLimit = this.findById(userId);
    if (userLimit.isEmpty()) {
      return;
    }
    userLimit.get().setValueLimit(userLimit.get().getValueLimit().add(request.getAmount()));
    userLimitRepository.save(userLimit.get());
  }

  @Scheduled(cron = "${limit-calculation.execution-time}")
  public void executeLimitCalculation() {
    if (!enabled) {
      return;
    }
    List<UserLimit> userLimitList = userLimitRepository.findAll();
    for (UserLimit userLimit : userLimitList) {
      userLimit.setValueLimit(valueLimit);
      userLimitRepository.save(userLimit);
    }

  }

}
