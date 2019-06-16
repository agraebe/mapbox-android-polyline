Mapbox Android API v8 Samples
===================================

Samples demonstrating how to use
[Mapbox SDK for Android v8](https://docs.mapbox.com/android/maps/overview/).

This repo contains the following samples:

1. [Sample](https://docs.mapbox.com/android/maps/examples/create-a-simple-map-view/): Create a simple map view
2. [Sample](https://docs.mapbox.com/android/maps/examples/create-a-line-layer/): Create a line layer

Pre-requisites
--------------

See each sample for pre-requisites.
All require an uptodate version of the Android build tools and the Android support repository.

Getting Started
---------------

These samples use the Gradle build system.

First download the samples by cloning this repository or downloading an archived
snapshot. (See the options at the top of the page.)

In Android Studio, use the "Import non-Android Studio project" or
"Import Project" option. Next select one of the sample directories that you downloaded from this
repository.
If prompted for a gradle configuration accept the default settings.

Alternatively use the "gradlew build" command to build the project directly.

Add your access token to the `PolyActivity.java` file.
See the [quick guide to getting an access token](https://docs.mapbox.com/help/how-mapbox-works/access-tokens/).