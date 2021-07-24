package com.icedevcloud.cp.enums;

public enum ActivityOrderStatusEnums {

    CREATE_ORDER("A", "报名成功"),
    PAY_SUCCESS("B", "支付成功"),
    PAY_ERROR("C", "订单取消"),
    MATCH_SUCCESS("D", "配对成功"),
    REFUND_SUCCESS("E", "退款成功"),
    REFUND_ERROR("F", "退款失败"),
    MATCH_ERROR("G", "配对失败"),
    CREATE_ERROR("H", "报名失败");

    private String code;

    private String name;

    ActivityOrderStatusEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
