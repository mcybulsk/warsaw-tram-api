package me.cybulski.public_transport.model;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The position of an object on Earth.
 *
 * @author Michał Cybulski
 */
public class Position {

    /**
     * Latitude - North-South.
     */
    protected final double latitude;

    /**
     * Longitude - West-East.
     */
    protected final double longitude;

    public Position(double latitude, double longitude) {
        Preconditions.checkArgument(latitude >= -90.0 && latitude <= 90.0);
        Preconditions.checkArgument(longitude >= -180 && longitude <= 180);

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        return new EqualsBuilder()
                .append(latitude, position.latitude)
                .append(longitude, position.longitude)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(latitude)
                .append(longitude)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .toString();
    }
}
