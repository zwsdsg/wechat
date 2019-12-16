package com.wechat.handle;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.util.Sha1Util;


@Controller
public class GetWechatRequest{

	@RequestMapping(value="getWechat", method=RequestMethod.GET)
	@ResponseBody
	public String getWechatrequest(String signature, String timestamp, String nonce, String echostr){
		if(echostr==null){return "error";}
		if (checkSignature(signature, timestamp, nonce)){
			
			//System.out.println(echostr);
			//System.out.println("xixixi");
			return echostr;
        }
		//System.out.println(mt.getContent());
		else return "";
	}

	@RequestMapping(value="getWechat", method=RequestMethod.POST )
	@ResponseBody
	public String typeofmessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			InputStream ins = request.getInputStream();
			//Document
			Document doc = reader.read(ins);
			Element root = doc.getRootElement();
			
			@SuppressWarnings("unchecked")
			List<Element> list = root.elements();
			for(Element e:list){
				map.put(e.getName(),e.getText());
			}
			//return map;
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map.get("MsgType").equals("event")){
			try {
				//out = response.getWriter();
				MessageDispatcher msgdis = new MessageDispatcher();
				out.write(msgdis.eventDispatcher(map));
			}finally{out.close();}
		}else{
			try {
				
				//out = response.getWriter();
				MessageDispatcher msgdis = new MessageDispatcher();
				out.write(msgdis.messageDispatcher(map));
				System.out.println("已经执行了消息发送程序");
			}finally{out.close();}	
		}
		return "success";
	}
	

	private boolean checkSignature(String signature, String timestamp, String nonce){
		
		 String [] arr = {"788954", timestamp, nonce};
	        Arrays.sort(arr);
	        StringBuffer sbf = new StringBuffer();
	        for (String str : arr){
	            sbf.append(str);
	        }
	        String getSignature = Sha1Util.encode(sbf.toString());
	        System.out.println(getSignature);
	        System.out.println(signature);
	        return signature.equals(getSignature);
	    }
}