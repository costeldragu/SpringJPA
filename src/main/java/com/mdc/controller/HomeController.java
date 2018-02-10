package com.mdc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mdc.model.PermissionModel;
import com.mdc.model.RoleModel;
import com.mdc.model.UserModel;
import com.mdc.repository.PermissionRepository;
import com.mdc.repository.RoleRepository;
import com.mdc.repository.UserRepository;
import com.mdc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@Transactional
public class HomeController {


    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public HomeController(UserService userService, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @RequestMapping("/")
    @JsonView
    public String indexPage() {
        return "try";
    }

    @RequestMapping("/addusers")
    public String addUsers() {

        Set<RoleModel> roleModels = new HashSet<>();
        permissionRepository.save(new PermissionModel().setName("read"));
        PermissionModel permissionModel = permissionRepository.findByName("read");

        Set<PermissionModel> permissionModels = new HashSet<>();
        permissionModels.add(permissionModel);

        roleRepository.save(new RoleModel().setPermissions(permissionModels).setName("ADMIN"));
        RoleModel roleModel = roleRepository.findByName("ADMIN");
        roleModels.add(roleModel);

        UserModel user = new UserModel().setPassword("123").setUsername("user").setEmail("mdc@soft.ro");
        user.setRoles(roleModels);
        UserModel saved = userService.save(user);

        UserModel user2 = new UserModel().setPassword("123").setUsername("user2").setEmail("mdc@soft.ro");
        user2.setRoles(roleModels);
        UserModel saved2 = userService.save(user2);

        return user.toString() + saved.toString() + saved2.toString();
    }

    @RequestMapping("/getAll")
    public String getUser() {

        Iterable<UserModel> user = userService.getAllUser();
        return user.toString();
    }
}
