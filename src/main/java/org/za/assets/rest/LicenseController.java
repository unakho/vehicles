package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.LicenseDto;
import org.za.assets.service.license.LicenseService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/license")
public class LicenseController {

    @Autowired
    LicenseService<LicenseDto> licenseService;

    @RequestMapping(value = "/list")
    public List<LicenseDto> list() {
        return licenseService.list();
    }

    @RequestMapping(value = "/get")
    public LicenseDto get(@PathVariable("id") UUID id)throws Exception {
        return licenseService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public LicenseDto create(@RequestBody LicenseDto license)throws Exception {
        return licenseService.create(license);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        licenseService.remove(id);
    }
}
