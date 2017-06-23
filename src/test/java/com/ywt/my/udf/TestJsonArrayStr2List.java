package com.ywt.my.udf;
import org.junit.Assert;
import org.junit.Test;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;
/**
 * Created by yu on 2017/6/23.
 */
public class TestJsonArrayStr2List {
    @Test
    public void test() {
        JsonArrayStr2List udf = new JsonArrayStr2List();
        final String JSON ="[{\"UserName\":\"ZHULI\"},{\"UserName2\":\"2\"}]";
        Assert.assertEquals("20150101", udf.evaluate(JSON));
    }
}