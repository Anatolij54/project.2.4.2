package ru.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.spring.mvc.dao.UserDAO;
import ru.spring.mvc.model.User;
import ru.spring.mvc.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

   @Autowired
   public void setUserRepository(UserRepository userRepository){
       this.userRepository = userRepository;
   }

    public User findByUserName(String name){
return userRepository.findByUserName(name);
   }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if(user == null) {throw new UsernameNotFoundException("user not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),user.getAuthorities());

    }
}