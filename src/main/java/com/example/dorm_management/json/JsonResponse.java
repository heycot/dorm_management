package com.example.dorm_management.json;

import java.util.Collection;

public class JsonResponse {

    private Integer code;
    private String  message;
    private Collection<Object> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<Object> getData() {
        return data;
    }

    public void setData(Collection<Object> data) {
        this.data = data;
    }

    public JsonResponse() {
    }

    public JsonResponse(Integer res_code, String message, Collection<Object> data) {
        this.code = res_code;
        this.message = message;
        this.data = data;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{"); // Bắt đầu một đối tượng JSON là dấu mở ngoặc nhọn

        sb.append("\"code\":\"" + getCode() + "\""); // dòng này có nghĩa là
        // "id":"Giá_Trị"
        sb.append(","); // sau mỗi cặp key/value là một dấu phẩy

        sb.append("\"message\":\"" + getMessage() + "\"");
        sb.append(",");

        sb.append("\"data\":\"" + getData() + "\"");

        sb.append("}"); // Kết thúc một đối tượng JSON là dấu đóng ngoặc nhọn

        return sb.toString();
    }

/*
    public void formatData() {
        String
        this.data = this.data.replaceAll();

    }*/
}