package org.za.assets.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Profile;
import org.za.assets.dto.ProfileDto;
import org.za.assets.repository.ProfileRepository;
import org.za.assets.service.CRUDService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
public class ProfileServiceImpl extends CRUDService implements ProfileService<ProfileDto> {

    //private ProfileRepository profileRepository;
    private Profile profile;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        super(profileRepository);
        profile = new Profile();
    }

    @Override
    public List<ProfileDto> list() {

        return super.listRecords().map(entity -> {
            Profile profile = (Profile)entity;

            return this.profile.mapFrom(profile);
        }).collect(Collectors.toList());
    }

    public ProfileDto get(UUID id) throws Exception{
        return this.profile.mapFrom((Profile) super.getRecord(id));
    }

    public ProfileDto create(ProfileDto dto) throws Exception{

        Profile profile = this.profile.mapTo(dto);
        profile = (Profile)super.createRecord(profile);

        return this.profile.mapFrom(profile);
    }

    public ProfileDto update(ProfileDto dto) throws Exception{

        Profile profile = this.profile.mapTo(dto);
        profile = (Profile)super.updateRecord(profile);

        return this.profile.mapFrom(profile);
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }
}
