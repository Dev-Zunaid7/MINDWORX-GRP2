/**
 * This is a Service class which implements UserDetailsService
 * it solves the business logic of verfiying a user and registering a user.
 */

package com.mindworx.alumnibackend.model.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServices implements UserDetailsService {

  @Autowired
  UserRepo userRepos;
  //verify  user by username
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    Optional<User> user = userRepos.findByUserName(username);

  // //login or sign-in user.
    user.orElseThrow(() -> new UsernameNotFoundException("Is it really you? " + username + " was not found."));

    return user.map(AUserDetail::new).get();
  } 
  
    //register or sign-up user.
}
