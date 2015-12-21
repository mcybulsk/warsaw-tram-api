package me.cybulski.pl.warszawa.um.api.public_transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.cybulski.pl.warszawa.um.api.public_transport.model.WarsawPublicTransportState;
import org.apache.commons.lang3.StringUtils;
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
            LOGGER.trace("Deserialize JSON: " + rawTransportStateData);

            return objectMapper.readValue(rawTransportStateData, WarsawPublicTransportState.class);
        } catch (IOException e) {
            String failureCause = "Error happened during JSON deserialization!";
            if (StringUtils.contains(rawTransportStateData, "Nieautoryzowany dost\\u0119p do danych")) {
                failureCause += " Unauthorized access! Wrong API Key?";
            }

            LOGGER.error(failureCause, e);
            LOGGER.debug("JSON: " + rawTransportStateData);

            throw new WarsawPublicTransportApiException(failureCause, e);
        }
    }
}
