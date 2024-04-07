package ru.vtb.toropov.limit.repository;

import ru.vtb.toropov.limit.model.UserLimit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository.
 *
 * @author DToropov
 */
public interface UserLimitRepository extends JpaRepository<UserLimit, Long> {

}
