package com.wechat.util;


import com.thoughtworks.xstream.XStream;
import com.wechat.beans.MessageText;

public class TextMessageToXml {

	public static String textMessageToXml(MessageText mt){
		
		XStream xstream = new XStream();
		System.out.println("����toxml����");
		xstream.alias("xml", mt.getClass());
		System.out.println(xstream.toXML(mt));
		return xstream.toXML(mt);
	}
}
