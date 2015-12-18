package me.cybulski.pl.warszawa.um.api.public_transport.model;

import me.cybulski.public_transport.model.Position;
import me.cybulski.public_transport.model.Vehicle;
import me.cybulski.public_transport.model.VehicleType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * A Warsaw public transport vehicle.
 *
 * @author Michał Cybulski
 */
public class WarsawVehicle extends Vehicle {

    protected final String lineNumber;
    protected final List<String> lines;
    protected final WarsawVehicleStatus status;
    protected final String brigade;
    protected final ZonedDateTime lastUpdateTs;
    protected final boolean lowFloor;

    public WarsawVehicle(Position position,
                         VehicleType vehicleType,
                         String lineNumber,
                         List<String> lines,
                         WarsawVehicleStatus status,
                         String brigade,
                         ZonedDateTime lastUpdateTs,
                         boolean lowFloor) {
        super(position, vehicleType);
        this.lineNumber = lineNumber;
        this.lines = lines;
        this.status = status;
        this.brigade = brigade;
        this.lastUpdateTs = lastUpdateTs;
        this.lowFloor = lowFloor;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public List<String> getLines() {
        return lines;
    }

    public WarsawVehicleStatus getStatus() {
        return status;
    }

    public String getBrigade() {
        return brigade;
    }

    public ZonedDateTime getLastUpdateTs() {
        return lastUpdateTs;
    }

    public boolean isLowFloor() {
        return lowFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof WarsawVehicle)) return false;

        WarsawVehicle that = (WarsawVehicle) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(lowFloor, that.lowFloor)
                .append(lineNumber, that.lineNumber)
                .append(lines, that.lines)
                .append(status, that.status)
                .append(brigade, that.brigade)
                .append(lastUpdateTs, that.lastUpdateTs)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(lineNumber)
                .append(lines)
                .append(status)
                .append(brigade)
                .append(lastUpdateTs)
                .append(lowFloor)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("lineNumber", lineNumber)
                .append("lines", lines)
                .append("status", status)
                .append("brigade", brigade)
                .append("lastUpdateTs", lastUpdateTs)
                .append("lowFloor", lowFloor)
                .toString();
    }
}
