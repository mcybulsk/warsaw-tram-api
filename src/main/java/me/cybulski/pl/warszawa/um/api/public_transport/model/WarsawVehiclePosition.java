package me.cybulski.pl.warszawa.um.api.public_transport.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.cybulski.public_transport.model.Position;

/**
 * Warsaw's vehicle position.
 *
 * @author Michał Cybulski
 */
public class WarsawVehiclePosition extends Position {

    @JsonCreator
    public WarsawVehiclePosition(@JsonProperty("Lat") double latitude,
                                 @JsonProperty("Lon") double longitude) {
        super(latitude, longitude);
    }
}
