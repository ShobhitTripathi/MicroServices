package com.benz.assignment.controller;

import com.benz.assignment.model.UserInfo;
import com.benz.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public String getUsers() {
        return userService.getAllUsers();
    }

//    @RequestMapping("/users/{name}")
//    public String getUser(@PathVariable("name") String name) {
//        return userService.getUser(name);
//    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserInfo userInfo,@PathVariable("name") String name) {
        return userService.updateUser(userInfo, name);
    }


}
