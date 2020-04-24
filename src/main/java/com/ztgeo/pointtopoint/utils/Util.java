package com.ztgeo.pointtopoint.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ztgeo.pointtopoint.controller.entity.CXR_MSGDirect;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Util {

    //取得当前时间并格式化成字符串
    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//改变输出格式（自己想要的格式）
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    /**
     * 验证不动产单元号
     * @param str bdcdyh
     * @return
     */
    public static boolean IsBdcDyh(String str){
        String regex="\\d{12}[A-Z]{2}\\d{5}[A-Z]{1}\\d{8}";
        return match(regex,str);
    }

    /**
     * @param
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    public static boolean match(String regex,String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 验证长度
     * @param str
     * @return
     */
    public static boolean IsLength(String str){
          String regex="^.{28,}$";
          return match(regex,str);
    }

    //取得当前时间并格式化成字符串,保存请求json
    public static String getDateString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//改变输出格式（自己想要的格式）
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    //取得当前时间并格式化为DATE日期,以便保存到数据库
    public static Date getSaveDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//改变输出格式（自己想要的格式）
        String dateString = formatter.format(currentTime);
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    //取得当前时间点作为文件名称
    public static String getFileName() {
        String dateString = getDateString();
        return dateString + ".txt";//得到字符串时间
    }

    //获取到的请求写入文件
    public static void writeToFile(String responseJSON, String qqccdz) {
        String path = qqccdz + "/" + Util.getFileName();
        log.info("接收到的请求存储地址:" + path);
        //true表示在文件末尾追加
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(path, true);
            fos.write(responseJSON.getBytes());
            fos.close();
            log.info("存储请求数据到txt成功");
        } catch (IOException e) {
            log.info("存储请求数据到txt失败：" + e);
            e.printStackTrace();
        }
    }

    //字符串null转为""
    public static String getToString(String string) {
        if (StringUtils.isBlank(string)) {
            return "";
        }
        return string;
    }

    //字符串转float
    public static String getDigitFormat(String mj) {
        if ("0".equals(mj)) {
            mj = "";
        }
        if (StringUtils.isNotBlank(mj)) {
            try {
                DecimalFormat df = new DecimalFormat("######0.00");
                double d1 = Double.parseDouble(mj);
                mj = df.format(d1);
            } catch (Exception e) {
                log.error("转换double出现异常,源数据{}", mj);
                return "";
            }

        }
        return mj;
    }

    public static String dateFormat(String sj) {
        if (StringUtils.isNotBlank(sj)) {
            sj = sj.replace("/", "-");
            if (sj.length() < 11) {
                sj = strToDate(sj).toString();
                sj = sj + " 00:00:00";
            }
            sj = strToDateLong(sj);
        }
        return sj;
    }

    public static String strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        String dateString = formatter.format(strtodate);
        return dateString;
    }

    //字符串转日期
    public static String strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        String dateString = formatter.format(strtodate);
        return dateString;
    }

    //四舍五入保留两位有效数字的百分比
    public static String percent(Integer num1, Integer num2) {
        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);
//        System.out.println("num1和num2的百分比为:" + result + "%");
        return result;
    }

    /**
     * 字符串反转
     *
     * @param s
     * @return
     */
    public static String reverse(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse(right) + reverse(left);
    }

    /**
     * cron表达式转为日期
     *
     * @param cron
     * @return
     */
    public static String getCronToDate(String cron) {
        cron = cron.substring(0, cron.indexOf("*"));
        String dateFormat = "ss mm HH";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            return null;
        }
        return date.getHours() + "时" + date.getMinutes() + "分" + date.getSeconds() + "秒";
    }

    public static String readFile(String filePath) throws IOException {
        File f = new File(filePath);
        FileReader fre = new FileReader(f);
        BufferedReader bre = new BufferedReader(fre);
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        while ((str = bre.readLine()) != null)    //●判断最后一行不存在，为空
        {
            stringBuffer.append(str);
        }
        bre.close();
        fre.close();
        return stringBuffer.toString();
    }

}
