package com.risa.boot.demo.service.api;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
