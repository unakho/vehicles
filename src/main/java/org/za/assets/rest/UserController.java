package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.UserDto;
import org.za.assets.service.user.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService<UserDto> userService;

    @RequestMapping(value = "/list")
    public List<UserDto> list() {
        return userService.list();
    }

    @RequestMapping(value = "/get/{id}")
    public UserDto get(@PathVariable("id") UUID id)throws Exception {
        return userService.get(id).get();
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public UserDto create(@RequestBody UserDto user)throws Exception {
        return userService.create(Optional.ofNullable(user)).get();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        userService.remove(id);
    }
}
