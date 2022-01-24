package com.exercise.webservice.client.demo02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public final class Helper {
    // 访问SAP服务
    public static String callSAP(passparameter pp, String httpUrl, String getdata) {
        String resultData = "";
        URL geturl = null;
        try {
            // 构造一个URL对象
            geturl = new URL(httpUrl);
        } catch (MalformedURLException e) {
            // Log.e(DEBUG_TAG, "MalformedURLException");
        }

        try {
            // 使用HttpURLConnection打开连接
            HttpURLConnection urlConn = (HttpURLConnection) geturl.openConnection();
            // 设置请求的超时时间
            urlConn.setReadTimeout(5000);
            urlConn.setConnectTimeout(5000);
            // 传递的数据
            // String data = "&UserName=" + URLEncoder.encode(pp.getUserName(),
            // "UTF-8")
            // + "&Password=" + URLEncoder.encode(pp.getPassword(), "UTF-8");
            // Windows验证 用户密码
            String datap = pp.getUserName() + ":" + pp.getPassword();
            String authorization = Base64.getEncoder().encodeToString(datap.getBytes());
            urlConn.setRequestProperty("Authorization", "Basic " + authorization);
            // 设置请求的头
            urlConn.setRequestProperty("Connection", "keep-alive");
            // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置请求的头
            urlConn.setRequestProperty("Content-Length", String.valueOf(getdata.getBytes().length));
            // 设置请求的头
            urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
            // 因为这个是post请求,设立需要设置为true
            urlConn.setDoOutput(true);
            urlConn.setDoInput(true);
            // 设置以POST方式
            urlConn.setRequestMethod("POST");

            // Post 请求不能使用缓存
            urlConn.setUseCaches(false);
            // 获取输出流
            // BufferedReader os = new BufferedReader(new
            // OutputStream(urlConn.getOutputStream()))
            OutputStream os = urlConn.getOutputStream();
            // byte[] content = data.getBytes("utf-8");
            os.write(getdata.getBytes());
            os.flush();
            os.close();
            int icode = urlConn.getResponseCode();
            if (icode == 200) {
                // 获取响应的输入流对象
                InputStream is = urlConn.getInputStream();
                // 创建字节输出流对象
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // 定义读取的长度
                int len;
                int irecord = 1;
                // 定义缓冲区
                byte buffer[] = new byte[1024];
                // 按照缓冲区的大小，循环读取
                // pp.setreocrds(len);
                while ((len = is.read(buffer)) != -1) {
                    // 根据读取的长度写入到os对象中
                    baos.write(buffer, 0, len);
                    irecord += 1;
                }
                // 释放资源
                is.close();
                baos.close();
                // 返回字符串
                resultData = new String(baos.toByteArray());
                irecord -= 1;
                pp.setreocrds(irecord);
                // resultData = "Success";
                return resultData;
            } else {
                urlConn.disconnect();
                resultData = "链接失败或者是帐号或密码输入错误!\n" + "登录失败 !.........";
                return resultData;
            }
        } catch (IOException e) {
            resultData = "无法连接";
            return resultData;
        }
        // return resultData;
    }

}