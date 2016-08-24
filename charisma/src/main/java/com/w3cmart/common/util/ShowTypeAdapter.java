package com.w3cmart.common.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.w3cmart.common.enums.ShowAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/8/24.
 */
public class ShowTypeAdapter
        implements JsonSerializer<ShowAble>
{
    static Logger logger = LoggerFactory.getLogger(ShowTypeAdapter.class);

    public JsonElement serialize(ShowAble showAble, Type arg1, JsonSerializationContext arg2)
    {
        JsonObject result = new JsonObject();
        result.addProperty("value", Integer.valueOf(showAble.value()));
        result.addProperty("name", showAble.name());
        result.addProperty("show", showAble.show());
        return result;
    }
}