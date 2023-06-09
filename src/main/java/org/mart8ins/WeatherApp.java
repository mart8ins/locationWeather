package org.mart8ins;

public class WeatherApp {
    public static void main(String[] args) {
        System.out.println("Getting IP address...");
        String ip = LocationIP.getLocationIP();
        System.out.println("Getting GEO data from...");
        LocationGeo.GeoResponse geoData = LocationGeo.getGeoFromIp(ip);
        System.out.println("Waiting for weather...");
        System.out.println(LocationWeather.getCurrentWeatherFromGeoData(geoData));
    }
}
