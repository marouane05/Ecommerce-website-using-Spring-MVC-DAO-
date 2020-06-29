package com.dryouch.account.dao;

import com.dryouch.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
