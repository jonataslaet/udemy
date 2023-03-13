package com.github.jonataslaet.services;

import com.github.jonataslaet.repositories.UserRepository;
import java.util.Objects;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final Logger logger = Logger.getLogger(UserService.class.getName());

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    logger.info("Finding one user by name " + username);
    var user = userRepository.findByUsername(username);
    if (Objects.nonNull(user)) {
      return user;
    } else {
      throw new UsernameNotFoundException("Username " + username + " not found!");
    }
  }
}
