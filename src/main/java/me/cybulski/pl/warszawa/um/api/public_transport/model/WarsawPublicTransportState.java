package me.cybulski.pl.warszawa.um.api.public_transport.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * A snapshot of the public transport state.
 *
 * @author Michał Cybulski
 */
public class WarsawPublicTransportState {

    // Object state
    protected final List<? extends WarsawVehicle> vehicles;

    @JsonCreator
    public WarsawPublicTransportState(@JsonProperty("result") List<WarsawTram> vehicles) {
        this.vehicles = vehicles;
    }

    public List<? extends WarsawVehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof WarsawPublicTransportState)) return false;

        WarsawPublicTransportState that = (WarsawPublicTransportState) o;

        return new EqualsBuilder()
                .append(vehicles, that.vehicles)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(vehicles)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("vehicles", vehicles)
                .toString();
    }
}
