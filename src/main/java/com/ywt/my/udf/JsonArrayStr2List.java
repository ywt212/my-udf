package com.ywt.my.udf;
import java.util.ArrayList;
import java.util.List;

import com.ywt.my.util.StringUtil;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * 将符合jsonArray形式字符串转化为json字符串列表
 *
 * @author bull
 * @created 2013-8-30
 *
 * @version 1.0
 */
public class JsonArrayStr2List extends UDF {

    public static Object evaluate(final String key) {
        if (StringUtil.isBlank(key)) {
            return null;
        }
        try {
            JSONArray ja = new JSONArray(key);
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < ja.length(); i++) {
                list.add(ja.getJSONObject(i).toString());
            }
            return list;
        } catch (JSONException e) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        final String JSON ="[{\"UserName\":\"ZHULI\"},{\"UserName2\":\"2\"}]";
//        System.out.println(JSON);
//        try {
//            JSONArray ja = new JSONArray(JSON);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

}