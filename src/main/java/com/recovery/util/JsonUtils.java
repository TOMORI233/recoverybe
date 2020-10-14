package com.recovery.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

public class JsonUtils {

    public static JsonObject transformJson(String jsonString){
        JsonReader reader = new JsonReader(new StringReader(jsonString));
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(reader).getAsJsonObject();
    }
}
