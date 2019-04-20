package org.za.assets.service.schedule;

import org.za.assets.dto.ScheduleDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface ScheduleService<T extends BaseDto> extends AssetsService<BaseDto> {

    //crud methods implicitly public abstract
    List<ScheduleDto> list();

    ScheduleDto get(UUID id)throws Exception;

    ScheduleDto create(ScheduleDto schedule) throws Exception;

    ScheduleDto update(ScheduleDto schedule) throws Exception;

    void remove(UUID id)throws Exception;
}
