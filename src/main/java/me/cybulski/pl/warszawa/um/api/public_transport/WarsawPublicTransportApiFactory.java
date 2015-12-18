package me.cybulski.pl.warszawa.um.api.public_transport;

/**
 * A factory for creating the {@link WarsawPublicTransportApi} instances.
 *
 * @author Michał Cybulski
 */
public final class WarsawPublicTransportApiFactory {

    private WarsawPublicTransportApiFactory() {
        // instantiation blocking
    }

    /**
     * Returns an instance of the {@link WarsawPublicTransportApi} interface.
     *
     * @param apiKey Warsaw API's API key needed for access to the data
     * @return an instance of the {@link WarsawPublicTransportApi} interface
     */
//    FIXME Add a possibility to change UserAgent
    public static WarsawPublicTransportApi createInstance(String apiKey) {
        WarsawPublicTransportApiConfiguration configuration = new WarsawPublicTransportApiConfiguration();
        return new WarsawPublicTransportApiImpl(createIntegrationService(configuration,
                                                                         apiKey,
                                                                         configuration.getLibraryUserAgent()),
                                                createObjectMappingService(configuration));
    }


    private static WarsawPublicTransportApiIntegrationService createIntegrationService(
            WarsawPublicTransportApiConfiguration configuration,
            String apiKey,
            String userAgent) {
        return new WarsawPublicTransportApiIntegrationServiceImpl(configuration,
                                                                  apiKey,
                                                                  userAgent);
    }

    private static WarsawPublicTransportObjectMappingService createObjectMappingService(
            WarsawPublicTransportApiConfiguration configuration) {
        return new WarsawPublicTransportObjectMappingServiceImpl(configuration.getObjectMapper());
    }
}
