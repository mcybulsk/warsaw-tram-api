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
