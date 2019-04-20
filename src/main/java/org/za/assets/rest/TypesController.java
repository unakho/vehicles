package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.TypesDto;
import org.za.assets.service.types.TypesService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/types")
public class TypesController {

    @Autowired
    TypesService<TypesDto> typesService;

    @RequestMapping(value = "/list")
    public List<TypesDto> list() {
        return typesService.list();
    }

    @RequestMapping(value = "/get")
    public TypesDto get(@PathVariable("id") UUID id) throws Exception{
        return typesService.get(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public TypesDto create(@RequestBody TypesDto types)throws Exception {
        return typesService.create(types);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        typesService.remove(id);
    }
}
