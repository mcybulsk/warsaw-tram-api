package me.cybulski.pl.warszawa.um.api.public_transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.cybulski.pl.warszawa.um.api.public_transport.model.WarsawPublicTransportState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * A default implementation of object mapping service.
 *
 * @author Michał Cybulski
 */
class WarsawPublicTransportObjectMappingServiceImpl implements WarsawPublicTransportObjectMappingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarsawPublicTransportObjectMappingServiceImpl.class);

    // Dependencies
    private ObjectMapper objectMapper;

    WarsawPublicTransportObjectMappingServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public WarsawPublicTransportState processWarsawPublicTransportState(String rawTransportStateData) {
        try {
            return objectMapper.readValue(rawTransportStateData, WarsawPublicTransportState.class);
        } catch (IOException e) {
            String failureCause = "Error happened during JSON deserialization!";
            LOGGER.error(failureCause, e);
            LOGGER.debug("JSON: " + rawTransportStateData);

            throw new WarsawPublicTransportApiException(failureCause, e);
        }
    }
}
