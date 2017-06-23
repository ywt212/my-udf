package com.ywt.my.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.serde2.io.DoubleWritable;


@Description(
        name = "mt_geodist",
        value = "_FUNC_(double lat1, double lng1, double lat2, double lng2) - Returns distance(meters) between two point.",
        extended = "Example: see http://wiki.sankuai.com/pages/viewpage.action?pageId=67275925"
)
public class UDFGeoDist extends UDF {
    private DoubleWritable distance = new DoubleWritable();

    public DoubleWritable evaluate(DoubleWritable lat1, DoubleWritable lng1, DoubleWritable lat2, DoubleWritable lng2) {
        if (lat1 == null || lng1 == null || lat2 == null || lng2 == null) {
            return null;
        }
        //1) 计算三个参数
        double dx = lng1.get() - lng2.get(); // 经度差值
        double dy = lat1.get() - lat2.get(); // 纬度差值
        double b = (lat1.get() + lat2.get()) / 2.0; // 平均纬度
        //2) 计算东西方向距离和南北方向距离(单位：米)，东西距离采用三阶多项式，南北采用一阶多项式即可
        double Lx = (0.05 * b * b * b - 19.16 * b * b + 47.13 * b + 110966) * dx; // 东西距离
        double Ly = (17 * b + 110352) * dy; // 南北距离
        //3) 用平面的矩形对角距离公式计算总距离
        distance.set(Math.sqrt(Lx * Lx + Ly * Ly));
        return distance;
    }
}

