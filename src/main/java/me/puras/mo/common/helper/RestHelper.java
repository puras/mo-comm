package me.puras.mo.common.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class RestHelper {
    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return headers;
    }
}
