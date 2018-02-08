package com.mdc.repository;

import com.mdc.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,Long> {
}
