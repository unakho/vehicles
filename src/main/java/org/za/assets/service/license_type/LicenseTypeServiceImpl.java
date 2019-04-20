package org.za.assets.service.license_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.LicenseType;
import org.za.assets.dto.LicenseTypeDto;
import org.za.assets.repository.LicenseTypeRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class LicenseTypeServiceImpl extends CRUDService implements LicenseTypeService<LicenseTypeDto> {

    private LicenseType licenseType;

    @Autowired
    public LicenseTypeServiceImpl(LicenseTypeRepository licenseTypeRepository) {
        super(licenseTypeRepository);
        licenseType = new LicenseType();
    }

    @Override
    public List<LicenseTypeDto> list() {

        return super.listRecords().map(entity -> {
            LicenseType licenseType = (LicenseType)entity;

            return this.licenseType.mapFrom(licenseType);
        }).collect(Collectors.toList());
    }

    public LicenseTypeDto get(UUID id) throws Exception{
        return this.licenseType.mapFrom((LicenseType) super.getRecord(id));
    }

    public LicenseTypeDto create(LicenseTypeDto dto)throws Exception {

        LicenseType licenseType = this.licenseType.mapTo(dto);
        licenseType = (LicenseType)super.createRecord(licenseType);

        return this.licenseType.mapFrom(licenseType);
    }

    public LicenseTypeDto update(LicenseTypeDto dto)throws Exception {

        LicenseType licenseType = this.licenseType.mapTo(dto);
        licenseType = (LicenseType)super.updateRecord(licenseType);

        return licenseType.mapFrom(licenseType);
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }
}
