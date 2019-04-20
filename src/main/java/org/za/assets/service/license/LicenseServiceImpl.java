package org.za.assets.service.license;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.License;
import org.za.assets.dto.LicenseDto;
import org.za.assets.repository.LicenseRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class LicenseServiceImpl extends CRUDService implements LicenseService<LicenseDto> {

    private License license;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        super(licenseRepository);
        license = new License();
    }

    @Override
    public List<LicenseDto> list() {

        return super.listRecords().map(entity -> {
            License license = (License) entity;
            LicenseDto dto = this.license.mapFrom(license);

            return dto;
        }).collect(Collectors.toList());
    }

    public LicenseDto get(UUID id) throws Exception{
        return this.license.mapFrom((License) super.getRecord(id));
    }

    public LicenseDto create(LicenseDto dto)throws Exception {

        License license = this.license.mapTo(dto);
        license = (License) super.createRecord(license);

        return this.license.mapFrom(license);
    }

    public LicenseDto update(LicenseDto dto) throws Exception{

        License license = this.license.mapTo(dto);
        license = (License) super.createRecord(license);

        return this.license.mapFrom(license);
    }

    public void remove(UUID id) throws Exception{
        super.removeRecord(id);
    }
}
