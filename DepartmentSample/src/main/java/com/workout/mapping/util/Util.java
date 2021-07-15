package com.workout.mapping.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Util {
	
	public static boolean isEmptyValue(String value) {
		return value == null || value.trim().length() == 0;
	}
	
    public static String urlEncoder(String normalValue) {
        try {
            if (!isEmptyValue(normalValue)) {
                return URLEncoder.encode(normalValue, "UTF-8");
            } else {
                return normalValue;
            }
        } catch (Exception ex) {
        	System.out.println(ex);
        }
        return normalValue;
    }
    
    public static String urlDecoder(String encodedValue) {
        try {
            if (!isEmptyValue(encodedValue)) {
                return URLDecoder.decode(encodedValue, "UTF-8");
            } else {
                return encodedValue;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return encodedValue;
    }
	
}
