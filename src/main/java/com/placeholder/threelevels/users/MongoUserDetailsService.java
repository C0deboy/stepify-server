package com.placeholder.threelevels.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Component
public class MongoUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  public MongoUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    } else {
      UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
      userBuilder.password(user.getPassword());
      userBuilder.roles("USER");
      return userBuilder.build();
    }
  }
}