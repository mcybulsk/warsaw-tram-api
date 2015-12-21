package me.cybulski.pl.warszawa.um.api.public_transport;

/**
 * Object responsible for integration with online Warsaw API. Provides data to {@link WarsawPublicTransportApi}.
 *
 * @author Michał Cybulski
 */
interface WarsawPublicTransportApiIntegrationService {

    /**
     * Sets UserAgent to be used in queries to the remote API.
     *
     * @param userAgent UserAgent to be used
     */
    void setUserAgent(String userAgent);

    /**
     * Returns raw (JSON) data representing {@link WarsawPublicTransportApi}.
     *
     * @return raw (JSON) data representing {@link WarsawPublicTransportApi}
     */
    String getWarsawPublicTransportStateRawData();
}
