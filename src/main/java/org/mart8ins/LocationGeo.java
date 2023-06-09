package org.mart8ins;
import kong.unirest.Unirest;

public class LocationGeo {
    private static final String GEO_API = "https://tools.keycdn.com/geo.json?host=";

    public static GeoResponse getGeoFromIp(String ip){
        StringBuilder requestQuery = new StringBuilder(GEO_API);
        requestQuery.append(ip);
        String query = requestQuery.toString();
        GeoResponse resp = null;
        try {
            resp = Unirest.get(query).header("User-Agent", "keycdn-tools:https://github.com/mart8ins").asObject(GeoResponse.class).getBody();
        } catch(Exception e) {
            System.out.println("There was some error fetching GEO data. Please try again later.");
        }
        return resp;
    }

    public class GeoResponse {
        private String status;
        private String description;
        private Data data;

        public String getStatus() {
            return status;
        }

        public String getDescription() {
            return description;
        }

        public Data getData() {
            return data;
        }

        @Override
        public String toString() {
            return "GeoResponse{" +
                    "status='" + status + '\'' +
                    ", description='" + description + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    public class Data {
        private Geo geo;

        public Geo getGeo() {
            return geo;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "geo=" + geo +
                    '}';
        }
    }

    public class Geo {
        private String country_name;
        private String city;
        private String latitude;
        private String longitude;

        public String getCountry_name() {
            return country_name;
        }

        public String getCity() {
            return city;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        @Override
        public String toString() {
            return "Geo{" +
                    "country_name='" + country_name + '\'' +
                    ", city='" + city + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }
    }


}
