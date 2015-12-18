package me.cybulski.pl.warszawa.um.api.public_transport;

import me.cybulski.pl.warszawa.um.api.public_transport.model.WarsawPublicTransportState;

/**
 * A default implementation of the {@link WarsawPublicTransportApi} interface.
 *
 * @author Michał Cybulski
 */
class WarsawPublicTransportApiImpl implements WarsawPublicTransportApi {

    // Dependencies
    private WarsawPublicTransportApiIntegrationService integrationService;
    private WarsawPublicTransportObjectMappingService objectMappingService;

    WarsawPublicTransportApiImpl(WarsawPublicTransportApiIntegrationService integrationService,
                                 WarsawPublicTransportObjectMappingService objectMappingService) {
        this.integrationService = integrationService;
        this.objectMappingService = objectMappingService;
    }

    @Override
    public WarsawPublicTransportState getPublicTransportState() {
        String rawData = integrationService.getWarsawPublicTransportStateRawData();

        return objectMappingService.processWarsawPublicTransportState(rawData);
    }
}
