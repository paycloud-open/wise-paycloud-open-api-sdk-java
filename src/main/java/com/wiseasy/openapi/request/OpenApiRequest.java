package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.OpenApiResponse;

import java.lang.reflect.ParameterizedType;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: API request object base class
 */
public abstract class OpenApiRequest<T extends OpenApiResponse> {

    /**
     * Get the type of API response object
     *
     * @return
     */
    public Class<T> getResponseClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Get the method name of the API request interface
     *
     * @return
     */
    public String getRequestMethod() {
        String className = this.getClass().getSimpleName();
        className = className.replace("Request", "");
        char[] chars = className.toCharArray();
        String method = "";
        for (char c : chars) {
            if ("".equals(method)) {
                method += (String.valueOf(c)).toLowerCase();
            } else {
                if (c >= 'A' && c <= 'Z') {
                    method += "." + (String.valueOf(c)).toLowerCase();
                } else {
                    method += String.valueOf(c);
                }
            }
        }
        return method;
    }

}
