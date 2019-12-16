package com.wechat.imgclassify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestHttpClient {

	/*24.6bd55566b223aab6307f8c86df46bac0.2592000.1548413128.282335-15228077
	 *24.f95191a27d9273c62196092e3e750cc1.2592000.1548413169.282335-15228077
	 * */
	@Test
	public void doget() throws ClientProtocolException, IOException{
		String url = getUrl();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(get);
		//获取响应实体（网页内容）
		HttpEntity entity = response.getEntity();
		String json = EntityUtils.toString(entity, "utf-8");
		JSONObject jsonObject = JSON.parseObject(json);
		String access_token = jsonObject.getString("access_token");
		
		
		//将其写入到文件中
		File file = new File("access_token.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fileWrite = new FileWriter(file.getName(),true);
		fileWrite.write(access_token);
		fileWrite.close();
		System.out.println("写入成功"+file.getAbsolutePath());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.print("当前时间："+formatter.format(new Date()));
	}
	
	private static String getUrl(){
		
		String client_id = "pVfAs713htuDKtK3xAPNndr2";
		String client_secret = "yYTbrGas462Gcq1VLqOAsi5tuMvNclw9";
		String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials"
				+ "&client_id="+client_id
				+"&client_secret="+client_secret;
		return url;
	}
	
	
	//@Test
	public String getAccessTokenLocation() throws ClientProtocolException, IOException{
		File file = new File("access_token.txt");
		String temp = "";
		if(!file.exists()){
			System.out.println("没有本地记录，将要执行请求时间程序");
			doget();
		}else{
			FileReader fileReader = new FileReader(file);
			BufferedReader read = new BufferedReader(fileReader);
			temp = read.readLine();
			System.out.println("取出的数据是："+temp);
		}
		return temp;
	}
	
}
