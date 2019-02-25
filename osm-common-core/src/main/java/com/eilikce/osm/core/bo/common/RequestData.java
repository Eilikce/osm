package com.eilikce.osm.core.bo.common;

import com.eilikce.osm.core.bo.CommonBo;

import java.io.Serializable;
import java.util.Map;

public class RequestData implements CommonBo, Serializable {
    private Map<String,Object> msg;
    private Map<String,Object> data;

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "msg=" + msg +
                ", data=" + data +
                '}';
    }
}
