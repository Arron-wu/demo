/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestJgroup
 * Author:   Arron-wql
 * Date:     2020/8/13 10:07
 * Description: 爬虫
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * 爬虫
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/8/13
 * @Version 1.0.0
 */
public class TestJgroup {

    public static void main(String[] args) {
        try {
            Document document = Jsoup.parse(new File("d://1.html"), "utf-8");
        //交付时间
        document.getElementById("deliveryTime").val("/");
        //十一条  十二条
        document.select(".w1").val("    /");
        document.getElementsMatchingText("补充协议：").next().empty();
        document.getElementsMatchingText("补充协议：")
                .next()
                .html("1、<input type=\"text\" name=\"agreement1\" class=\"input-rent\" value=\" /\" style=\"width:600px\">");
        document.getElementsMatchingText("补充协议：").next().next().empty();
        document.getElementsMatchingText("补充协议：")
                .next().next()
                .html("2、<input type=\"text\" name=\"agreement1\" class=\"input-rent\" value=\" /\" style=\"width:600px\">");
        File file = new File("d://2.html");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(document.toString());// 往文件里写入字符串
//            ps.append("http://www.jb51.net");// 在已有的基础上添加字符串
			ps.flush();
			ps.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


}