package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.RouteDto;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "route")
public class Route extends BaseEntity {

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "end_address")
    private String endAddress;

    private Double mileage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public Route() {
    }

    public Route(UUID id, String startAddress, String endAddress, Double mileage) {
        super(id);
        setStartAddress(startAddress);
        setEndAddress(endAddress);
        setMileage(mileage);
    }

    String getStartAddress() {
        return startAddress;
    }

    private void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    String getEndAddress() {
        return endAddress;
    }

    private void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    Double getMileage() {
        return mileage;
    }

    private void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*
     * @param dto
     * @return route entity
     * This method is used by services that are related with Route entity
     * @link RouteServiceImpl
     */
    public Route mapTo(RouteDto dto) {

        if (dto == null)
            throw new RuntimeException("Route dto is null!");

        return new Route(dto.getId(), dto.getStartAddress(), dto.getEndAddress(), dto.getMileage());
    }

    /*
     * @param route
     * @return dto
     * This method is used by services that are related with Route entity
     * @link RouteServiceImpl
     */
    public RouteDto mapFrom(Route route) {

        if (route == null)
            throw new RuntimeException("Route entity is null!");

        return new RouteDto(route.getId(), route.getStartAddress(),
                route.getEndAddress(), route.getMileage());
    }

}
