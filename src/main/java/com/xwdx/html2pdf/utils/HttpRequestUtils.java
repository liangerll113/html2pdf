package com.xwdx.html2pdf.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author kongmingliang
 * @date 2021-12-17 14:22
 **/
@Component
public class HttpRequestUtils {

    public static RestTemplate restTemplate;

    public static JSONObject get4Json(String url, JSONObject requestHeaders, JSONObject urlParam) {
        try {
            HttpHeaders headers = buildHttpHeaders(requestHeaders);
            url = buildUrl(url, urlParam);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            System.out.printf("url=%s", url);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String result = responseEntity.getBody();
            return JSON.parseObject(result);
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject post4Json(String url, JSONObject requestBody) {
        return post4Json(url, null, null, requestBody);
    }

    public static JSONObject post4Json(String url, JSONObject requestHeaders, JSONObject requestBody) {
        return post4Json(url, requestHeaders, null, requestBody);
    }

    public static JSONObject post4Json(String url, JSONObject requestHeaders, JSONObject urlParam, JSONObject requestBody) {
        return null;
    }

    private static HttpHeaders buildHttpHeaders(JSONObject headerParam) {
        HttpHeaders headers = new HttpHeaders();
        for (String key : headerParam.keySet()) {
            headers.set(key, headerParam.getString(key));
        }
        return headers;
    }

    private static String buildUrl(String url, JSONObject urlParam) {
        url += "?";
        for (String key : urlParam.keySet()) {
            url += key + "=" + urlParam.getString(key) + "&";
        }
        url = url.substring(0, url.length() - 1);
        return url;
    }

    private HttpRequestUtils() {
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        HttpRequestUtils.restTemplate = restTemplate;
    }
}
