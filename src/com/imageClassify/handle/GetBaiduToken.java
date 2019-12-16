package com.imageClassify.handle;

//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;


@Controller
public class GetBaiduToken {

	@Test
	public void getAuth() {
		// 官网获取的 API Key 更新为你注册的
		String clientId = "pVfAs713htuDKtK3xAPNndr2";
		// 官网获取的 Secret Key 更新为你注册的
		String clientSecret = "yYTbrGas462Gcq1VLqOAsi5tuMvNclw9 ";
		getAuth(clientId, clientSecret);
	}

	
	public static String getAuth(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
		// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + ak
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + sk;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
			JSON json = JSONSerializer.toJSON(result);
			System.err.println("result:" + result);
			//Object temObj = JSONSerializer.toJava(json);
			String access_token = json.toString(1);
			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}

}
