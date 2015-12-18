package me.cybulski.pl.warszawa.um.api.public_transport;

/**
 * Exception representing a non-recoverable problem with Warsaw Public Transport API.
 *
 * @author Michał Cybulski
 */
public class WarsawPublicTransportApiException extends RuntimeException {

    public WarsawPublicTransportApiException(String message) {
        super(message);
    }

    public WarsawPublicTransportApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
