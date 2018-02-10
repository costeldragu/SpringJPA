package com.mdc.services;

import com.mdc.model.UserModel;

import java.util.Iterator;

public interface UserService {
    UserModel save(UserModel user);
    Iterable<UserModel> getAllUser();
}
