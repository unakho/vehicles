package org.za.assets.service.types;

import org.za.assets.dto.TypesDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.service.AssetsService;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public interface TypesService<T extends BaseDto> extends AssetsService<BaseDto> {

    List<TypesDto> list();

    TypesDto get(UUID id) throws Exception;

    TypesDto create(TypesDto vehicle) throws Exception;

    TypesDto update(TypesDto vehicle) throws Exception;

    void remove(UUID id) throws Exception;
}
