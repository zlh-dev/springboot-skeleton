package com.code.util;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常收集工具
 *
 * @author zlh-dev
 * @date 2020/07/05 11:35:43
 */
public class ExceptionUtil {
    private static final Log log = LogFactory.get();

    /**
     * 打印异常信息
     */
    public static String getMessage(Exception e) {
        String swStr = null;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr = sw.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return swStr;
    }
}