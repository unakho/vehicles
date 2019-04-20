package org.za.assets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.za.assets.domain.base.BaseEntity;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author unakho.kama
 */
@Component
public abstract class CRUDService {

    private CrudRepository crudRepository;

    public CRUDService(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }
    //common methods needed by the services to perform CRUD operations
    protected Stream<BaseEntity> listRecords() {
        return StreamSupport.stream(crudRepository.findAll().spliterator(), false);
    }

    protected BaseEntity getRecord(UUID id)throws Exception {

        Optional<BaseEntity> entity = (Optional<BaseEntity>)crudRepository.findById(id);
        if (entity == null)
            throw new Exception("Record id " + id + " is not found!");

        return entity.get();
    }

    protected BaseEntity createRecord(BaseEntity entity){

        if (entity.getId() != null)
            entity.setId(null);

        entity = (BaseEntity) crudRepository.save(entity);

        return entity;
    }

    protected BaseEntity updateRecord(BaseEntity entity)throws Exception {

        entity = getRecord(entity.getId());
        entity = (BaseEntity)crudRepository.save(entity);
        return entity;
    }

    protected void removeRecord(UUID id)throws Exception {
        BaseEntity entity = getRecord(id);
        crudRepository.delete(entity);
    }
}
