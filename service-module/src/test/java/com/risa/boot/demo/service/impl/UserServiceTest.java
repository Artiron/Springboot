package com.risa.boot.demo.service.impl;


import com.risa.boot.demo.entity.User;
import com.risa.boot.demo.service.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    @Transactional
    public void createUserTest() {
        User user = new User();
        user.setUsername("Artiron");
        user.setPassword("1");
        userService.save(user);
       // Assert.
    }
}
