package com.ywt.my.udf;


import org.apache.hadoop.hive.ql.exec.UDF;


public final class Date2DateKey extends UDF {
    public String evaluate(final String s) {
        return new D2d().evaluate(s, "-", "");
    }
}