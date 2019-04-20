package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.LicenseTypeDto;
import org.za.assets.service.license_type.LicenseTypeService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/license_type")
public class LicenseTypeController {

    @Autowired
    LicenseTypeService<LicenseTypeDto> licenseTypeService;

    @RequestMapping(value = "/list")
    public List<LicenseTypeDto> list() {
        return licenseTypeService.list();
    }

    @RequestMapping(value = "/get")
    public LicenseTypeDto get(@PathVariable("id") UUID id)throws Exception {
        return licenseTypeService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public LicenseTypeDto create(@RequestBody LicenseTypeDto licenseType)throws Exception {
        return licenseTypeService.create(licenseType);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        licenseTypeService.remove(id);
    }
}
