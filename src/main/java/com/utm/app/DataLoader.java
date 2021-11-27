package com.utm.app;

import com.utm.app.dao.entity.User;
import com.utm.app.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;

@Component
public class DataLoader implements ApplicationRunner {
  private final UserRepository userRepository;

  @Autowired
  public DataLoader(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    User user1 = new User("Alex");
    User user2 = new User("Jora");
    User user3 = new User("Fedea");
    User user4 = new User("Ion");
    userRepository.saveAll(new LinkedList<>(Arrays.asList(user1, user2, user3, user4)));
  }
}
