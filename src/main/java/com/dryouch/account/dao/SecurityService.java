package com.dryouch.account.dao;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
