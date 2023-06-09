package org.mart8ins;

import kong.unirest.Unirest;

public class LocationWeather {
    private static String longitude;
    private static String latitude;
    private static String WEATHER_API = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true&forecast_days=1";

    public static String getCurrentWeatherFromGeoData(LocationGeo.GeoResponse geoData){
        String city = geoData.getData().getGeo().getCity();
        String country = geoData.getData().getGeo().getCountry_name();
        latitude = geoData.getData().getGeo().getLatitude();
        longitude = geoData.getData().getGeo().getLongitude();
        String query = String.format(WEATHER_API, latitude, longitude);

        String dispayWeather = "";

        try {
            WeatherResponse weatherResponse = Unirest.get(query).asObject(WeatherResponse.class).getBody();

            String temperature = weatherResponse.getCurrent_weather().getTemperature();
            String windspeed= weatherResponse.getCurrent_weather().getWindspeed();
            dispayWeather = String.format("Your location: %s, %s. Current temperature is %s °C with %s km/h windspeed.", country, city, temperature, windspeed);
        } catch(Exception e){
            System.out.println("There was some error fetching weather data. Please try again later.");
        }
        return dispayWeather;
    }

    public class WeatherResponse {
        private CurrentWeather current_weather;

        public CurrentWeather getCurrent_weather() {
            return current_weather;
        }

        @Override
        public String toString() {
            return "WeatherResponse{" +
                    "current_weather=" + current_weather +
                    '}';
        }
    }

    public class CurrentWeather {
        private String temperature;
        private String windspeed;

        public String getTemperature() {
            return temperature;
        }

        public String getWindspeed() {
            return windspeed;
        }

        @Override
        public String toString() {
            return "CurrentWeather{" +
                    "temperature='" + temperature + '\'' +
                    ", windspeed='" + windspeed + '\'' +
                    '}';
        }
    }
}
