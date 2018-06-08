package org.za.assets.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.assets.domain.License;
import org.za.assets.domain.User;
import org.za.assets.domain.Vehicle;
import org.za.assets.dto.LicenseDto;
import org.za.assets.dto.UserDto;
import org.za.assets.dto.VehicleDto;
import org.za.assets.repository.UserRepository;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author unakho.kama
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> list() {

        Stream<User> stream = StreamSupport.stream(userRepository.findAll().spliterator(), false);
        return stream.map(user -> mapFrom(user)).collect(Collectors.toList());
    }

    public UserDto get(Long id) {
        return mapFrom(userRepository.findOne(id));
    }

    public UserDto create(UserDto dto) {

        User user = mapTo(dto);
        user = userRepository.save(user);

        return mapFrom(user);
    }

    public UserDto update(UserDto dto) {

        User user = mapTo(dto);
        user = userRepository.save(user);

        return mapFrom(user);
    }

    public void remove(Long id) {
        userRepository.delete(id);
    }


    private User mapTo(UserDto dto) {

        User user = new User();
        user.setId(dto.getId());
        user.setSurname(dto.getSurname());
        user.setIdNo(dto.getIdNo());
        user.setContactNo(dto.getContactNo());
        user.setNetwork(dto.getNetwork());
        user.setPoints(dto.getPoints());
        user.setCardNumber(dto.getCardNumber());
        user.setGender(dto.getGender());

        return user;
    }

    private UserDto mapFrom(User user) {

        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getIdNo(), user.getContactNo(),
                user.getNetwork(), user.getPoints(), user.getCardNumber(), user.getGender());
    }

    private VehicleDto mapFrom(Vehicle vehicle) {

        return new VehicleDto(vehicle.getId(), vehicle.getName(), vehicle.getModel(), vehicle.getType(),
                vehicle.getRegNo());
    }

    private LicenseDto mapFrom(License license) {

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();

        return new LicenseDto(license.getId(), license.getCode(),
                ldtac.convertToEntityAttribute(license.getExpiryDate()));
    }
}
