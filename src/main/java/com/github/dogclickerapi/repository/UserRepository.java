package com.github.dogclickerapi.repository;

import com.github.dogclickerapi.entiity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByTelegramId(Long telegramId);

  List<User> findTop5ByOrderByScoreDesc();
}
