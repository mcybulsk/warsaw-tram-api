package me.cybulski.public_transport.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An object representing a vehicle.
 *
 * @author Michał Cybulski
 */
public class Vehicle {

    protected final Position position;

    protected final VehicleType vehicleType;

    public Vehicle(Position position, VehicleType vehicleType) {
        this.position = position;
        this.vehicleType = vehicleType;
    }

    public Position getPosition() {
        return position;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        return new EqualsBuilder()
                .append(position, vehicle.position)
                .append(vehicleType, vehicle.vehicleType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(position)
                .append(vehicleType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("position", position)
                .append("vehicleType", vehicleType)
                .toString();
    }
}
