package com.wiseasy.openapi.utils;

import java.io.*;

/**
 * @program: wise-paycloud-open-api-sdk-java
 * @description:
 * @author: jzj
 * @create: 2022-06-14 13:35
 **/
public class FileUtil {

    public static byte[] file2Byte(File file) {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();

            int ch;
            while ((ch = in.read()) != -1) {
                out.write(ch);
            }

            bytes = out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }
}
