package me.cybulski.pl.warszawa.um.api.public_transport.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.cybulski.public_transport.model.VehicleType;

import java.time.ZonedDateTime;

/**
 * A representation of Warsaw train.
 *
 * @author Michał Cybulski
 */
public class WarsawTram extends WarsawVehicle {

    @JsonCreator
    public WarsawTram(@JsonProperty("Lat") double lat,
                      @JsonProperty("Lon") double lon,
                      @JsonProperty("FirstLine") String lineNumber,
                      @JsonProperty("Lines") String lines,
                      @JsonProperty("Status") String status,
                      @JsonProperty("Brigade") String brigade,
                      @JsonProperty("Time") ZonedDateTime lastUpdateTs,
                      @JsonProperty("LowFloor") boolean lowFloor) {
        super(new WarsawVehiclePosition(lat, lon),
              VehicleType.TRAM,
              WarsawApiInputProcessingUtil.processLineNumber(lineNumber),
              WarsawApiInputProcessingUtil.processLines(lines),
              WarsawApiInputProcessingUtil.processStatus(status),
              WarsawApiInputProcessingUtil.processBrigade(brigade),
              lastUpdateTs,
              lowFloor);
    }
}
