package com.gorodev.dictionary.util;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T getObject(String url, Class<T> clazz) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpget = new HttpGet(url);

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            return OBJECT_MAPPER.readValue(responseBody, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}