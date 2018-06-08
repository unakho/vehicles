package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.UserDto;
import org.za.assets.service.user.UserService;

import java.util.List;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public List<UserDto> list() {
        return userService.list();
    }

    @RequestMapping(value = "/get")
    public UserDto get(@PathVariable("id") Long id) {
        return userService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public UserDto create(@RequestBody UserDto user) {
        return userService.create(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        userService.remove(id);
    }
}
