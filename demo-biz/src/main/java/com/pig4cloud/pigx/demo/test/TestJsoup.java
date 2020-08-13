/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestJsoup
 * Author:   Arron-wql
 * Date:     2020/8/13 14:05
 * Description: 爬虫
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 爬虫
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/8/13
 * @Version 1.0.0
 */
public class TestJsoup {

		public static void main(String[] args) {
			//1.生成httpclient，相当于该打开一个浏览器
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			//2.创建get请求，相当于在浏览器地址栏输入 网址
			HttpGet request = new HttpGet("https://www.cnblogs.com/");
			//设置请求头，将爬虫伪装成浏览器
			request.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
            //代理IP
//			HttpHost proxy = new HttpHost("60.13.42.232", 9999);
//			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//			request.setConfig(config);
			File file = new File("d://爬虫.txt");
			PrintStream ps = null;
			try {
				//3.执行get请求，相当于在输入地址栏后敲回车键
				response = httpClient.execute(request);
				//4.判断响应状态为200，进行处理
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					//5.获取响应内容
					HttpEntity httpEntity = response.getEntity();
					String html = EntityUtils.toString(httpEntity, "utf-8");
					//6.Jsoup解析html
					Document document = Jsoup.parse(html);
					//获取title
					System.out.println(document.getElementsByTag("title").first());
					//获取文章列表元素对象
					//Element postList = document.getElementById("post_list");
					//通过class 获取列表下的所有博客
					Elements postItems = document.getElementsByClass("post-item");
					//先把之前的内容读取出来
					String s = readString("d://爬虫.txt");
					//获取输出流
					ps = new PrintStream(new FileOutputStream(file));
					//写入时间
					ps.println();
					ps.println("/*");
					ps.println("*当前时间"+ DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
					ps.println("/*");
					ps.println();
					//循环处理每篇博客
					for (Element postItem : postItems) {
						//获取文章标题元素
						Elements titleEle = postItem.select(".post-item-text a[class='post-item-title']");
						System.out.println("文章标题:" + titleEle.text());;
						ps.println("文章标题:" + titleEle.text());
						System.out.println("文章地址:" + titleEle.attr("href"));
						ps.println("文章地址:" + titleEle.attr("href"));
						//获取文章作者元素
						Elements footEle = postItem.select(".post-item-foot a[class='post-item-author']");
						System.out.println("文章作者:" + footEle.text());
						ps.println("文章作者:" + footEle.text());
						System.out.println("作者主页:" + footEle.attr("href"));
						ps.println("作者主页:" + footEle.attr("href"));
						System.out.println("*********************************");
						ps.println("*********************************");
					}
					//把之前的内容写进去
					ps.println(s);
				} else {
					//处理404（页面不存在）等情况  通过发邮件的方式告知开发人员  todo
					System.out.println("返回状态不是200");
					System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//6.关闭
				HttpClientUtils.closeQuietly(response);
				HttpClientUtils.closeQuietly(httpClient);
				ps.flush();
				ps.close();
			}
		}

	/**
	 * 将文本文件内容读成字符串
	 * @param filePath  文本路径
	 * @return
	 */
	private static String readString(String filePath)
	{
		String str="";
		File file=new File(filePath);
		try {
			FileInputStream in=new FileInputStream(file);
			// size  为字串的长度 ，这里一次性读完
			int size=in.available();
			byte[] buffer=new byte[size];
			in.read(buffer);
			in.close();
			return str=new String(buffer,"utf-8");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}



}