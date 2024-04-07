package ru.vtb.toropov.limit.controller;

import ru.vtb.toropov.limit.dtos.PaymentDto;
import ru.vtb.toropov.limit.model.UserLimit;
import ru.vtb.toropov.limit.service.UserLimitService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController.
 *
 * @author DToropov
 */
@RestController
public class UserLimitController {

  private UserLimitService userLimitService;

  @Autowired
  public void setUserLimitService(UserLimitService userLimitService) {
    this.userLimitService = userLimitService;
  }

  @GetMapping("/userLimit/{id}")
  public Optional<UserLimit> findById(@PathVariable Long id) {
    return userLimitService.findById(id);
  }

  @PostMapping("/makePayment")
  public void makePayment(@RequestHeader("userId") Long userId, @RequestBody PaymentDto request) {
    userLimitService.makePayment(userId, request);
  }
  @PostMapping("/rollbackPayment")
  public void rollbackPayment(@RequestHeader("userId") Long userId, @RequestBody PaymentDto request) {
    userLimitService.rollbackPayment(userId, request);
  }
}
