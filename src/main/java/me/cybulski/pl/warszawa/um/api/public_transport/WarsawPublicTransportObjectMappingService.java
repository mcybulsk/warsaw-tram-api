package me.cybulski.pl.warszawa.um.api.public_transport;

import me.cybulski.pl.warszawa.um.api.public_transport.model.WarsawPublicTransportState;

/**
 * A service used for mapping raw data to Java objects.
 *
 * @author Michał Cybulski
 */
interface WarsawPublicTransportObjectMappingService {

    /**
     * Returns a {@link WarsawPublicTransportState} object mapped from raw data.
     *
     * @param rawTransportStateData raw data
     * @return a {@link WarsawPublicTransportState} object mapped from raw data
     */
    WarsawPublicTransportState processWarsawPublicTransportState(String rawTransportStateData);
}
