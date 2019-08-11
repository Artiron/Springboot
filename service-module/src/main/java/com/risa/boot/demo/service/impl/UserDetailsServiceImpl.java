package com.risa.boot.demo.service.impl;


import com.risa.boot.demo.entity.Role;
import com.risa.boot.demo.entity.User;
import com.risa.boot.demo.repository.RoleRepository;
import com.risa.boot.demo.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Primary
@Service
public class UserDetailsServiceImpl extends UserServiceImpl implements UserDetailsService{


    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(userRepository, roleRepository, bCryptPasswordEncoder);
    }

    @Override
    //@Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public UserDetails loadUserByUsername(String username) {
        User user = this.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
