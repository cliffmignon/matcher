package com.cliff.common.config;

import java.util.Map;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    String[] DATABASE_PROPERTY_NAMES = { "username", "password", "url" };
    private static Map<String, String> databaseMap = null;//TODO 此处换成你的加密方式获取，格式为{username:xxxxx}
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProperty(propertyName)) {
            return databaseMap.get(propertyName);
        }
        return super.convertProperty(propertyName, propertyValue);
    }

    private boolean isEncryptProperty(String pname) {
        for (String name : DATABASE_PROPERTY_NAMES) {
            if (name.equals(pname)) {
                return true;
            }
        }
        return false;
    }
}