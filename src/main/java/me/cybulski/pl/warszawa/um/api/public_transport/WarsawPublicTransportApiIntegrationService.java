package me.cybulski.pl.warszawa.um.api.public_transport;

/**
 * Object responsible for integration with online Warsaw API. Provides data to {@link WarsawPublicTransportApi}.
 *
 * @author Michał Cybulski
 */
interface WarsawPublicTransportApiIntegrationService {

    /**
     * Returns raw (JSON) data representing {@link WarsawPublicTransportApi}.
     *
     * @return raw (JSON) data representing {@link WarsawPublicTransportApi}
     */
    String getWarsawPublicTransportStateRawData();
}
