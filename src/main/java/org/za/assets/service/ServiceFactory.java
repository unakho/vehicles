package org.za.assets.service;

import org.za.assets.repository.*;
import org.za.assets.service.license.LicenseServiceImpl;
import org.za.assets.service.license_type.LicenseTypeServiceImpl;
import org.za.assets.service.profile.ProfileServiceImpl;
import org.za.assets.service.route.RouteServiceImpl;
import org.za.assets.service.types.TypesServiceImpl;
import org.za.assets.service.vehicle.VehicleServiceImpl;

/**
 * @author unakho.kama
 * marker interface
 */
public class ServiceFactory {

    private static LicenseRepository licenseRepository;
    private static LicenseTypeRepository licenseTypeRepository;
    private static ProfileRepository profileRepository;
    private static RouteRepository routeRepository;
    private static ScheduleRepository scheduleRepository;
    private static TypesRepository typesRepository;
    private static UserRepository userRepository;
    private static VehicleRepository vehicleRepository;

    public static AssetsService getService(String name){

        switch (name){
            case "license":
                return new LicenseServiceImpl(licenseRepository);
            case "licenseType":
                return new LicenseTypeServiceImpl(licenseTypeRepository);
            case "profile":
                return new ProfileServiceImpl(profileRepository);
            case "route":
                return new RouteServiceImpl(routeRepository);
           /* case "schedule":
                return new ScheduleServiceImpl(scheduleRepository);*/
            case "types":
                return new TypesServiceImpl(typesRepository);
            /*case "user":
                return new UserServiceImpl(userRepository);*/
            case "vehicle":
                return new VehicleServiceImpl(vehicleRepository);
        }

        throw new UnsupportedOperationException("Unsupported Service "+ name);
    }
}
