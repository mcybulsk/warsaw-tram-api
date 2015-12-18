package me.cybulski.pl.warszawa.um.api.public_transport.model;

import com.google.common.base.Preconditions;
import me.cybulski.pl.warszawa.um.api.public_transport.WarsawPublicTransportApiException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * A set of tools for processing the raw input from the API.
 *
 * @author Michał Cybulski
 */
class WarsawApiInputProcessingUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarsawApiInputProcessingUtil.class);

    static String processLineNumber(String rawFirstLineNumber) {
        Preconditions.checkNotNull(rawFirstLineNumber);

        return rawFirstLineNumber.trim();
    }

    static List<String> processLines(String rawLines) {
        Preconditions.checkNotNull(rawLines);
        String processingLinesString = rawLines.trim();

        List<String> result = Arrays.asList(processingLinesString.split(","));
        result.removeIf(StringUtils::isBlank);

        return result;
    }

    static WarsawVehicleStatus processStatus(String rawStatus) {
        Preconditions.checkNotNull(rawStatus);
        String processedStatusString = rawStatus.trim();

        for (WarsawVehicleStatus warsawVehicleStatus : WarsawVehicleStatus.values()) {
            if (warsawVehicleStatus.name().equalsIgnoreCase(processedStatusString)) {
                return warsawVehicleStatus;
            }
        }

        String failureReason = String.format("There is no WarsawVehicleStatus for rawStatus: '%s'",
                                             rawStatus);
        LOGGER.error(failureReason);

        throw new WarsawPublicTransportApiException(failureReason);
    }

    static String processBrigade(String rawBrigade) {
        Preconditions.checkNotNull(rawBrigade);

        return rawBrigade.trim();
    }
}
