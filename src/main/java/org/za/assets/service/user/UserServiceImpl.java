package org.za.assets.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.Profile;
import org.za.assets.domain.Route;
import org.za.assets.domain.User;
import org.za.assets.domain.Vehicle;
import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.ProfileDto;
import org.za.assets.dto.RouteDto;
import org.za.assets.dto.UserDto;
import org.za.assets.dto.VehicleDto;
import org.za.assets.dto.base.BaseDto;
import org.za.assets.repository.ProfileRepository;
import org.za.assets.repository.RouteRepository;
import org.za.assets.repository.UserRepository;
import org.za.assets.repository.VehicleRepository;
import org.za.assets.service.CRUDService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Service
//@Primary
public class UserServiceImpl extends CRUDService implements UserService<UserDto> {

    private VehicleRepository vehicleRepository;
    private RouteRepository routeRepository;
    private ProfileRepository profileRepository;
    private User user;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, VehicleRepository vehicleRepository,
                           RouteRepository routeRepository,
                           ProfileRepository profileRepository) {

        super(userRepository);
        this.vehicleRepository = vehicleRepository;
        this.profileRepository = profileRepository;
        this.routeRepository = routeRepository;
        //this object is responsible for calling
        user = new User();
    }

    @Override
    public List<UserDto> list() {

        return super.listRecords().map(entity -> {

            User user = (User)entity;
            UserDto dto = this.user.mapFrom(user);
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<UserDto> addVehicles(Optional<UserDto> dto) throws Exception{

        Optional<User> user = Optional.of((User)super.getRecord(dto.get().getId()));

        List<BaseDto> dtos = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        dto.get().getVehicles().forEach(vehicleDto -> dtos.add(vehicleDto));

        List<BaseEntity> entities = addRelation(dtos);
        entities.forEach(entity -> {
            Vehicle vehicle = (Vehicle) entity;
            vehicles.add(vehicle);
        });

        user.get().setVehicles(vehicles);
        user = Optional.of((User) super.createRecord(user.get()));

        return Optional.of(this.user.mapFrom(user.get()));
    }

    public Optional<UserDto> addProfiles(Optional<UserDto> dto) throws Exception{

        Optional<User> user = Optional.of(null);//(User)super.getRecord(dto.get().getId()));

        List<BaseDto> dtos = new ArrayList<>();
        List<Profile> profiles = new ArrayList<>();
        dto.get().getProfiles().forEach(profileDto -> dtos.add(profileDto));

        List<BaseEntity> entities = addRelation(dtos);
        entities.forEach(entity -> {
            Profile profile = (Profile)entity;
            profiles.add(profile);
        });

        user.get().setProfiles(profiles);
        user = Optional.of((User) super.createRecord(user.get()));

        return Optional.of(this.user.mapFrom(user.get()));
    }

    public Optional<UserDto> addRoutes(Optional<UserDto> dto) throws Exception{

        Optional<User> user = Optional.of(null);//(User)super.getRecord(dto.get().getId()));

        List<BaseDto> dtos = new ArrayList<>();
        List<Route> routes = new ArrayList<>();
        dto.get().getRoutes().forEach(routeDto -> dtos.add(routeDto));

        List<BaseEntity> entities = addRelation(dtos);
        entities.forEach(entity -> {
            Route route = (Route) entity;
            routes.add(route);
        });

        user.get().setRoutes(routes);
        user = Optional.of((User) super.createRecord(user.get()));

        return Optional.of(this.user.mapFrom(user.get()));
    }

    public Optional<UserDto> get(UUID id) throws Exception{
        Optional<User> user = Optional.of(null);//(User)super.getRecord(id));
        return Optional.of(this.user.mapFrom(user.get()));
    }

    public Optional<UserDto> create(Optional<UserDto> dto) throws Exception {

        if (dto.get().getLicense() == null)
            throw new Exception("License is compulsory for a user!");

        User user = this.user.mapTo(dto.get());
        user = (User)super.createRecord(user);

        return Optional.of(this.user.mapFrom(user));
    }

    public Optional<UserDto> update(Optional<UserDto> dto) throws Exception{

        User user = this.user.mapTo(dto.get());
        user = (User)super.updateRecord(user);

        return Optional.of(this.user.mapFrom(user));
    }

    public void remove(UUID id)throws Exception {
        super.removeRecord(id);
    }

    private List<BaseEntity> addRelation(List<BaseDto> dtos){
        List<BaseEntity> entities = new ArrayList<>();
        if (!dtos.isEmpty()){
            dtos.forEach(dto -> {

                if (dto instanceof VehicleDto){
                    Vehicle vehicle = this.user.addVehicle((VehicleDto) dto);
                    vehicle = vehicleRepository.save(vehicle);
                    entities.add(vehicle);
                }

                if (dto instanceof ProfileDto){
                    Profile profile = this.user.addProfile((ProfileDto) dto);
                    profile = profileRepository.save(profile);
                    entities.add(profile);
                }

                if (dto instanceof RouteDto){
                    Route route = this.user.addRoute((RouteDto) dto);
                    route = routeRepository.save(route);
                    entities.add(route);
                }
            });
            return entities;
        }
        else {
            return Collections.EMPTY_LIST;
        }
    }
}
