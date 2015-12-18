package me.cybulski.pl.warszawa.um.api.public_transport;

import me.cybulski.pl.warszawa.um.api.public_transport.model.WarsawPublicTransportState;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Test for {@link WarsawPublicTransportObjectMappingServiceImpl}.
 *
 * Tests mapping from JSON to Java. More of an integration test than really a unit test. Useful though :)
 *
 * @author Michał Cybulski
 */
public class WarsawPublicTransportObjectMappingServiceImplTest {

    /**
     * Returns the initialized test subject.
     *
     * @return initialized test subject
     */
    private WarsawPublicTransportObjectMappingService getWarsawPublicTransportObjectMappingServiceImpl() {
        return new WarsawPublicTransportObjectMappingServiceImpl(
                new WarsawPublicTransportApiConfiguration().getObjectMapper());
    }

    /**
     * Returns a test real-life JSON to be parsed.
     *
     * @return a test real-life JSON to be parsed
     */
    private String getPublicTransportStateRawTestJSON() throws IOException {
        File testFile = new File(
                getClass().getClassLoader().getResource("api.um.warszawa.pl-trams-test.json").getFile());
        BufferedReader reader = new BufferedReader(new FileReader(testFile));

        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            stringBuilder.append(inputLine);
        }
        reader.close();

        return stringBuilder.toString();
    }

    @Test
    public void testPublicTransportStateMapping() throws IOException {
        // given
        String rawJson = getPublicTransportStateRawTestJSON();
        WarsawPublicTransportObjectMappingService mappingService = getWarsawPublicTransportObjectMappingServiceImpl();

        // when
        WarsawPublicTransportState transportState = mappingService.processWarsawPublicTransportState(rawJson);

        // then
        Assertions.assertThat(transportState.getVehicles().size()).isEqualTo(244);
    }
}