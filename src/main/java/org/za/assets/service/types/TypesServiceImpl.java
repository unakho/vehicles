package org.za.assets.service.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Types;
import org.za.assets.dto.TypesDto;
import org.za.assets.repository.TypesRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class TypesServiceImpl extends CRUDService implements TypesService<TypesDto> {

    private Types types;

    @Autowired
    public TypesServiceImpl(TypesRepository typesRepository) {
        super(typesRepository);
        types = new Types();
    }

    @Override
    public List<TypesDto> list() {

        return super.listRecords().map(entity -> {
            Types types = (Types)entity;

            return this.types.mapFrom(types);
        }).collect(Collectors.toList());
    }

    public TypesDto get(UUID id)throws Exception {
        return this.types.mapFrom((Types) super.getRecord(id));
    }

    public TypesDto create(TypesDto dto)throws Exception {

        Types types = this.types.mapTo(dto);
        types = (Types) super.createRecord(types);

        return this.types.mapFrom(types);
    }

    public TypesDto update(TypesDto dto) throws Exception{

        Types types = this.types.mapTo(dto);
        types = (Types) super.updateRecord(types);

        return this.types.mapFrom(types);
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }
}
