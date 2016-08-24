package com.w3cmart.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.w3cmart.common.base.exception.BusinessException;
import com.w3cmart.common.enums.ShowAble;
import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by Administrator on 2016/8/24.
 */
public class ViewResult {
    Logger logger = LoggerFactory.getLogger(ViewResult.class);
    String message;
    int state;
    Object data;
    Pagination page;
    Collection<? extends Object> rows = new ArrayList();

    private static GsonBuilder GSON_BUILDER = new GsonBuilder().setDateFormat("yyyyMMdd'T'HHmmssZ")
            .registerTypeHierarchyAdapter(ShowAble.class, new ShowTypeAdapter());

    Map<String, List<? extends Object>> dict = new HashMap();

    public static ViewResult newInstance()
    {
        return new ViewResult();
    }

    public ViewResult put(String key, Object Object)
    {
        if (this.data == null) {
            this.data = new HashMap();
        }
        Assert.isTrue(this.data instanceof Map, "使用put 方法时 原始数据data 必须为 map类型 " + this.data.getClass());
        ((Map)this.data).put(key, Object);
        return this;
    }

    public ViewResult data(Object data)
    {
        Assert.isNull(this.data, "data 数据已经赋值，不能重复赋值" + this.data);
        this.data = data;
        return this;
    }

    public ViewResult dict(String key, List<?> list)
    {
        this.dict.put(key, list);
        return this;
    }

    public ViewResult rows(Collection<? extends Object> list)
    {
        this.rows = list;
        return this;
    }

    public <T> T rows()
    {
        return (T) this.rows;
    }

    public <T> T data()
    {
        return (T) this.data;
    }

    public String json(Gson gson)
    {
        Map content = new HashMap();
        content.put("data", this.data);
//        content.put("total", Integer.valueOf(((Pagination)Objects.firstNonNull(this.page, Pagination.currentPagination())).totalCount));
        content.put("total", Integer.valueOf(20));
        content.put("dict", this.dict);
        content.put("rows", this.rows);

        Map result = new HashMap();
        result.put("content", content);
        result.put("message", this.message);
        result.put("state", Integer.valueOf(this.state));

        String out = gson.toJson(result);

//        HttpServletRequest request = ThreadContent.request();
//        String jsoncallback = request.getParameter("jsoncallback");
//        if (!StringUtil.isEmpty(jsoncallback)) {
//            return jsoncallback + "(" + out + ")";
//        }

        return out;
    }

    public String json()
    {
        return json(GSON_BUILDER.create());
    }

    public ViewResult fail()
    {
        return fail("操作失败");
    }

    public ViewResult fail(String message)
    {
        return state(100, message);
    }

    public ViewResult state(int state, String message)
    {
        this.message = message;
        this.state = state;
        return this;
    }

    public ViewResult fail(BusinessException e)
    {
        state(e.state, e.getMessage());
        return this;
    }

    public ViewResult state(ResultState state)
    {
        state(state.state, state.messge);
        return this;
    }

//    public ViewResult page(Pagination page)
//    {
//        this.page = page;
//        rows(page.rows);
//        return this;
//    }
}
