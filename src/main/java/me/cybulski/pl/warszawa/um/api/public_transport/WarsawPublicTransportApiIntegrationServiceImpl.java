package me.cybulski.pl.warszawa.um.api.public_transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A default implementation of data providing integration service.
 *
 * @author Michał Cybulski
 */
class WarsawPublicTransportApiIntegrationServiceImpl implements WarsawPublicTransportApiIntegrationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(WarsawPublicTransportApiIntegrationServiceImpl.class);

    // Constants
    private final String METHOD_GET = "GET";
    private final String HEADER_USER_AGENT = "UserAgent";

    // Endpoints
    private final String warsawTramApiWsEndpointUrl;

    // Client information
    private String userAgent;
    private final String apiKey;

    WarsawPublicTransportApiIntegrationServiceImpl(WarsawPublicTransportApiConfiguration configuration,
                                                   String apiKey,
                                                   String userAgent) {
        this.warsawTramApiWsEndpointUrl = configuration.getWarsawTramApiWsEndpointUrl();
        this.apiKey = apiKey;
        this.userAgent = userAgent;
    }

    @Override
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getWarsawPublicTransportStateRawData() {
        return getHttpData(warsawTramApiWsEndpointUrl);
    }

//    FIXME Add validation for common error API responses with proper mapping to WarsawPublicTransportApiException

    /**
     * Gets data from a HTTP endpoint using the API key.
     *
     * @param endpointUrlString String url to the HTTP endpoint
     * @return if request was successful, raw data from the HTTP endpoint; throws exceptions otherwise
     */
    private String getHttpData(String endpointUrlString) {
        HttpURLConnection httpURLConnection = null;
        try {
            String requestUrlString = endpointUrlString + "&apikey=" + apiKey;
            URL endpointUrl = new URL(requestUrlString);

            LOGGER.trace("Sending request to: " + requestUrlString + " with UserAgent: " + userAgent);
            httpURLConnection = (HttpURLConnection) endpointUrl.openConnection();
            httpURLConnection.setRequestMethod(METHOD_GET);
            httpURLConnection.setRequestProperty(HEADER_USER_AGENT, userAgent);

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            return response.toString();
        } catch (IOException e) {
            throw new WarsawPublicTransportApiException("Problem occurred during HTTP request!",
                                                        e);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

    }
}
