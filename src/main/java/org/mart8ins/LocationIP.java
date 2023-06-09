package org.mart8ins;

import kong.unirest.Unirest;

public class LocationIP {
    private static final String IP_API = "https://api.ipify.org/?format=json";

    private static String ip;
    public static String getLocationIP(){
        try{
            ip = Unirest.get(IP_API).asObject(IpResponse.class).getBody().ip;
        } catch(Exception e){
            System.out.println("There was some error fetching IP address. Please try again later.");
        }
        return ip;
    };

    private class IpResponse {
        public String ip;
    }
}
