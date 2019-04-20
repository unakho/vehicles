package org.za.assets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.za.assets.dto.ScheduleDto;
import org.za.assets.service.schedule.ScheduleService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService<ScheduleDto> scheduleService;

    @RequestMapping(value = "/list")
    public List<ScheduleDto> list() {
        return scheduleService.list();
    }

    @RequestMapping(value = "/get")
    public ScheduleDto get(@PathVariable("id") UUID id)throws Exception {
        return scheduleService.get(id);
    }
    @RequestMapping(value = "/add/route", method = RequestMethod.PUT)
    public void addRoute(@RequestBody ScheduleDto schedule)throws Exception  {
        //scheduleService.addRoutes(schedule);
    }
    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public ScheduleDto create(@RequestBody ScheduleDto user)throws Exception {
        return scheduleService.create(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") UUID id)throws Exception {
        scheduleService.remove(id);
    }
}
