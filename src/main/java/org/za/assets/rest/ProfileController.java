package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.ProfileDto;
import org.za.assets.service.profile.ProfileService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService<ProfileDto> profileService;

    @RequestMapping(value = "/list")
    public List<ProfileDto> list() {
        return profileService.list();
    }

    @RequestMapping(value = "/get")
    public ProfileDto get(@PathVariable("id") UUID id)throws Exception {
        return profileService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public ProfileDto create(@RequestBody ProfileDto profile) throws Exception{
        return profileService.create(profile);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        profileService.remove(id);
    }
}
