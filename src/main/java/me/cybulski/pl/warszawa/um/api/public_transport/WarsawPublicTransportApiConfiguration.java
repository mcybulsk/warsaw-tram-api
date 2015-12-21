package me.cybulski.pl.warszawa.um.api.public_transport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Warsaw Public Transport API configuration class.
 *
 * @author Michał Cybulski
 */
class WarsawPublicTransportApiConfiguration {

    // Constants
    private static final String WARSAW_TRAM_API_WS_ENDPOINT_URL =
            "https://api.um.warszawa.pl/api/action/wsstore_get?id=c7238cfe-8b1f-4c38-bb4a-de386db7e776";

    // Identification
    private static final String LIBRARY_USER_AGENT = "java-warsaw-public-transport-api";

    // Configured tools and utils
    private final ObjectMapper objectMapper;

    WarsawPublicTransportApiConfiguration() {
        this.objectMapper = new ObjectMapper();
        initObjectMapper();
    }

    private void initObjectMapper() {
        objectMapper.registerModule(new JavaTimeModule());

        SimpleModule zonedDateTimeDeserializerModule = new SimpleModule();
        zonedDateTimeDeserializerModule.addDeserializer(
                ZonedDateTime.class,
                new JsonDeserializer<ZonedDateTime>() {
                    @Override
                    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt)
                            throws IOException {
                        String dateString = p.getValueAsString();
                        LocalDateTime localDateTime = LocalDateTime.parse(dateString);
                        return localDateTime.atZone(ZoneId.of("Europe/Warsaw"));
                    }
                });
        objectMapper.registerModule(zonedDateTimeDeserializerModule);
    }

    String getWarsawTramApiWsEndpointUrl() {
        return WARSAW_TRAM_API_WS_ENDPOINT_URL;
    }

    String getLibraryUserAgent() {
        return LIBRARY_USER_AGENT;
    }

    ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
