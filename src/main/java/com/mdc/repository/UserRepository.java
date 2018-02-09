package com.mdc.repository;

import com.mdc.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<UserModel,Long> {
}
