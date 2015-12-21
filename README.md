This API is in the beginning stages of the development. It may possibly still change severely.

# warsaw-public-transport-api
A simple Java library for an easy access to the Warsaw City Public Transport API,
which is available at https://api.um.warszawa.pl/

## Available data
It is possible to obtain near-realtime (there is approximately one minute of delay) data containing the positions of
all the trams currently running in the city of Warsaw.

For now there is no information about other types of vehicles.

## Library installation
```
./gradlew publishToMavenLocal
```

## Usage in Gradle projects
```
compile 'me.cybulski:warsaw-public-transport-api:0.1.0-dev'
```

## Sample code
```
/**
 * Example java-warsaw-public-transport-api program.
 *
 * @author Michał Cybulski
 */
public class Main {

    public static void main(String[] args) {
        WarsawPublicTransportApi publicTransportApi = WarsawPublicTransportApiFactory.createInstance("secret");
        WarsawPublicTransportState warsawPublicTransportState = publicTransportApi.getPublicTransportState();

        for (WarsawVehicle warsawVehicle : warsawPublicTransportState.getVehicles()) {
            Position position = warsawVehicle.getPosition();
            System.out.println(
                    String.format("Line: %s, Latitude: %f, Longitude: %f, UpdateTs: %s",
                                  warsawVehicle.getLineNumber(),
                                  position.getLatitude(),
                                  position.getLongitude(),
                                  warsawVehicle.getLastUpdateTs().toString()));
        }
    }
}
```

## ... and output:
```
Line: 6, Latitude: 52.283478, Longitude: 20.956368, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 24, Latitude: 52.282116, Longitude: 20.920832, UpdateTs: 2015-12-21T23:55:25+01:00[Europe/Warsaw]
Line: 6, Latitude: 52.270363, Longitude: 20.980309, UpdateTs: 2015-12-21T23:55:27+01:00[Europe/Warsaw]
Line: 3, Latitude: 52.250908, Longitude: 21.039892, UpdateTs: 2015-12-21T23:55:22+01:00[Europe/Warsaw]
Line: 24, Latitude: 52.240906, Longitude: 21.109749, UpdateTs: 2015-12-21T23:55:25+01:00[Europe/Warsaw]
Line: 28, Latitude: 52.295578, Longitude: 20.932455, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 7, Latitude: 52.202560, Longitude: 21.000191, UpdateTs: 2015-12-21T23:55:27+01:00[Europe/Warsaw]
Line: 14, Latitude: 52.176022, Longitude: 20.943882, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 24, Latitude: 52.227474, Longitude: 20.986937, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 23, Latitude: 52.253040, Longitude: 21.050892, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 20, Latitude: 52.247810, Longitude: 20.922501, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 14, Latitude: 52.275150, Longitude: 20.980488, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.224529, Longitude: 20.933455, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 14, Latitude: 52.232536, Longitude: 20.998644, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 10, Latitude: 52.231545, Longitude: 20.969940, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 10, Latitude: 52.238987, Longitude: 20.905375, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 10, Latitude: 52.214977, Longitude: 21.020723, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 24, Latitude: 52.231751, Longitude: 21.020775, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 14, Latitude: 52.238243, Longitude: 21.006729, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.202427, Longitude: 20.969057, UpdateTs: 2015-12-21T23:55:27+01:00[Europe/Warsaw]
Line: 23, Latitude: 52.255764, Longitude: 21.054867, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.246189, Longitude: 21.069681, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 3, Latitude: 52.308224, Longitude: 21.015917, UpdateTs: 2015-12-21T23:55:15+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.244652, Longitude: 21.084974, UpdateTs: 2015-12-21T23:55:22+01:00[Europe/Warsaw]
Line: 35, Latitude: 52.256115, Longitude: 20.981932, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.242958, Longitude: 21.074808, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.202786, Longitude: 20.969292, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 4, Latitude: 52.311058, Longitude: 21.012846, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 1, Latitude: 52.283787, Longitude: 20.956184, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 4, Latitude: 52.272888, Longitude: 21.032673, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.231560, Longitude: 21.019741, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.244083, Longitude: 21.080982, UpdateTs: 2015-12-21T23:55:25+01:00[Europe/Warsaw]
Line: 17, Latitude: 52.263989, Longitude: 20.978720, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.249222, Longitude: 21.043470, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.176025, Longitude: 20.943743, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.220264, Longitude: 20.984619, UpdateTs: 2015-12-21T23:55:22+01:00[Europe/Warsaw]
Line: 3, Latitude: 52.238129, Longitude: 21.118918, UpdateTs: 2015-12-21T23:55:27+01:00[Europe/Warsaw]
Line: 3, Latitude: 52.245174, Longitude: 21.086361, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.244568, Longitude: 21.084955, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.239941, Longitude: 20.987501, UpdateTs: 2015-12-21T23:55:07+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.298706, Longitude: 20.934492, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 26, Latitude: 52.231388, Longitude: 20.915014, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.238171, Longitude: 21.118792, UpdateTs: 2015-12-21T23:55:25+01:00[Europe/Warsaw]
Line: 17, Latitude: 52.181877, Longitude: 20.988747, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.237949, Longitude: 21.051035, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.226669, Longitude: 20.997070, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 15, Latitude: 52.189274, Longitude: 21.001970, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 35, Latitude: 52.177303, Longitude: 21.021292, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 35, Latitude: 52.260262, Longitude: 20.924774, UpdateTs: 2015-12-21T23:55:26+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.205601, Longitude: 20.971886, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 9, Latitude: 52.177437, Longitude: 20.945326, UpdateTs: 2015-12-21T23:55:25+01:00[Europe/Warsaw]
Line: 17, Latitude: 52.208290, Longitude: 21.007877, UpdateTs: 2015-12-21T23:55:24+01:00[Europe/Warsaw]
Line: 1, Latitude: 52.311150, Longitude: 21.012682, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
Line: 17, Latitude: 52.222752, Longitude: 21.004833, UpdateTs: 2015-12-21T23:55:27+01:00[Europe/Warsaw]
Line: 17, Latitude: 52.280865, Longitude: 20.958878, UpdateTs: 2015-12-21T23:55:23+01:00[Europe/Warsaw]
```
