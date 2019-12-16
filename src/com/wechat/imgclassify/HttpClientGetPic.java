package com.wechat.imgclassify;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSON;


public class HttpClientGetPic {

	/*根据地址返回图片绝对地址
	 * */
	public String returnpicLocation(String url){
		//String url = "http://linanqu.superlib.libsou.com/uploads/1/image/public/201812/20181218162417_tolqhqv3wd.jpg";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		
		File file = new File("2.jpg");
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			HttpEntity entity = httpResponse.getEntity();
			if(entity!=null){
				InputStream inputStream = entity.getContent();
				
				//inputStream.
				//Base64.encodeBase64(inputStream);
				 byte b[] = new byte[1024];
                 int j = 0;
                 while( (j = inputStream.read(b))!=-1){
                     outputStream.write(b,0,j);
                 }
                 outputStream.flush();
                 outputStream.close();
                 System.out.println("图片已经下载完成"+file.getAbsolutePath());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file.getAbsolutePath();
		//return new String(Base64.encodeBase64(picdate));
	}
	
	
	
	
	
	
	public String getPicName(String url) throws Exception{
		//手动控制互联网图片
		//String url = "https://s1.st.meishij.net/r/51/205/2301301/s2301301_154583099306723.jpg";
		
		
		
		//发起请求的url
		 String posturl = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
		
		//获取本地已经缓存的accesstoken
		TestHttpClient th = new TestHttpClient();
		String accesstoken = th.getAccessTokenLocation();
		
		//获取下载到本地的文件路径（绝对路径）
		String filePath = returnpicLocation(url);
		
		//对图片进行base64编码
		byte[] imgData = FileUtil.readFileByBytes(filePath);
        String imgStr = Base64Util.encode(imgData);
        String imgParam = URLEncoder.encode(imgStr, "UTF-8");
        String param = "image=" + imgParam + "&top_num=" + 5;
		
        String result = HttpUtil.post(posturl, accesstoken, param);
        //System.out.println(result);
		System.out.println("识别结果是"+result);
		return result;
	}
	
	
	public void getBeansFromBaiduAi(String result_of_baiduai){
		//JSONArray jsonArray = JSON.parse(result_of_baiduai).parseArray("result");
		String json = (String) JSON.parseArray("result").getJSONObject(1).parse("name");
	}
	
	
}
