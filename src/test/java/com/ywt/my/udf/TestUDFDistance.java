package com.ywt.my.udf;
import org.junit.Assert;
import org.junit.Test;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;
/**
 * Created by yu on 2017/6/23.
 */
public class TestUDFDistance {
    @Test
    public void test() {
        UDFGeoDist dis = new UDFGeoDist();
        Assert.assertEquals(9744.533203125, dis.evaluate(new DoubleWritable(39.989815), new DoubleWritable(116.433237), new DoubleWritable(39.915044), new DoubleWritable(116.492943)).get(), 1.0);
        Assert.assertNull(dis.evaluate(null, new DoubleWritable(39.989815), new DoubleWritable(116.433237), new DoubleWritable(39.915044)));
    }
}
