package com.ywt.my.udf;
import org.junit.Assert;
import org.junit.Test;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;
/**
 * Created by yu on 2017/6/23.
 */
public class TestDate2DateKey {
    @Test
    public void test() {
        Date2DateKey udf = new Date2DateKey();
        Assert.assertEquals("20150101", udf.evaluate("2016-01-01"));
    }
}
