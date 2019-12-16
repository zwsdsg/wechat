package com.wechat.handle;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.wechat.beans.MessageText;
import com.wechat.getToken.dao.GetwechatInfo;
import com.wechat.imgclassify.HttpClientGetPic;

public class MessageDispatcher {

	
	
	
	/*�����Ϣҵ����ַ�
	 * @author zws
	 * @input requestMap
	 * */
	public String messageDispatcher(Map<String, String> map) throws Exception{
		
		// ���ͷ��ʺţ�open_id��
        String fromUserName = map.get("FromUserName");
        // �����ʺ�
        String toUserName = map.get("ToUserName");
        // ��Ϣ����
        String msgType = map.get("MsgType");
        // ��Ϣ����
       String content = map.get("Content");
       
       GetwechatInfo getWechatInfo = new GetwechatInfo();
		
		//��Ϣ����
		if(map.get("MsgType").equals("text")){
			String reply = getWechatInfo.getReply(content);
			if(reply != ""){
				MessageText text = new MessageText();
				text.setContent(reply);
				text.setToUserName(fromUserName);
				text.setFromUserName(toUserName);
				text.setCreateTime(new Date().getTime()+"");
				text.setMsgType(msgType);
				text.setMsgId(map.get("MsgId"));
				return textMessageToXml(text);
			}
			
			
			/*MessageText text = new MessageText();
			text.setContent("爱你哦，丹阳");
			text.setToUserName(fromUserName);
			text.setFromUserName(toUserName);
			text.setCreateTime(new Date().getTime()+"");
			text.setMsgType(msgType);
			text.setMsgId(map.get("MsgId"));
			return textMessageToXml(text);*/
		}
		//ͼƬ����
		if(map.get("MsgType").equals("image")){
			MessageText text = new MessageText();
			System.out.println("接收到内容，并且进入到了判定环节");
			String url = map.get("PicUrl");
			HttpClientGetPic hcgp = new HttpClientGetPic();
			String picname = hcgp.getPicName(url);
			//先对获取的数据进行加工
			
			
			//然后对内容进行发送
			
			text.setContent(picname);
			text.setToUserName(fromUserName);
			text.setFromUserName(toUserName);
			text.setCreateTime(new Date().getTime()+"");
			text.setMsgType("text");
			text.setMsgId(map.get("MsgId"));
			System.out.println(text);
			return textMessageToXml(text);
			
			
		}
		//��������
		if(map.get("MsgType").equals("voice")){
			MessageText text = new MessageText();
			System.out.println("1234");
			text.setContent("你说的语音描述是："+map.get("Recognition"));
			text.setToUserName(fromUserName);
			text.setFromUserName(toUserName);
			text.setCreateTime(new Date().getTime()+"");
			text.setMsgType("text");
			text.setMsgId(map.get("MsgId"));
			System.out.println(text);
			return textMessageToXml(text);
		}
		//��Ƶ����
		if(map.get("MsgType").equals("video")){
			
		}
		//С��Ƶ����
		if(map.get("MsgType").equals("shortvideo")){
			
		}
		//����λ��
		if(map.get("MsgType").equals("location")){
			System.out.println("==============���ǵ���λ����Ϣ��");
		}
		//��������
		if(map.get("MsgType").equals("link")){
			System.out.println("==============����������Ϣ��");
		}
		return null;
	}
	
	
	/*�¼���Ϣ��ҵ��ַ�����
	 * @author zws
	 * @input requestMap
	 * */
	public String eventDispatcher(Map<String, String> map){
		
		// ���ͷ��ʺţ�open_id��
        String fromUserName = map.get("FromUserName");
        // �����ʺ�
        String toUserName = map.get("ToUserName");
        // ��Ϣ����
       // String msgType = map.get("MsgType");
        // ��Ϣ����
       //String content = map.get("Content");
		
		//����
		if(map.get("Event").equals("subscribe")){
			MessageText text = new MessageText();
			text.setContent("欢迎关注老子的微信公众号");
			text.setMsgId(map.get("MsgId"));
			text.setToUserName(fromUserName);
			text.setFromUserName(toUserName);
			text.setCreateTime(new Date().getTime()+"");
			text.setMsgType("text");
			//text.setMsgId(map.get("MsgId"));
			System.out.println(textMessageToXml(text));
			return textMessageToXml(text);
		}
		//ȡ������
		if(map.get("Event").equals("unsubscribe")){
			System.out.println("ȡ�����Ŀ�");
		}
		//ɨ���������ά���¼�
		if(map.get("Event").equals("SCAN")){
			System.out.println("");
		}
		//�ϱ�����λ���¼�
		if(map.get("Event").equals("LOCATION")){
			System.out.println("");
		}
		//�Զ���˵��¼�
		if(map.get("Event").equals("CLICK")){
			System.out.println("");
		}
		//�����Զ���˵�View�¼�
		if(map.get("Event").equals("VIEW")){
			System.out.println("");
		}
		return null;
	}
	
	
	public String textMessageToXml(MessageText mt){
		XStream xstream = new XStream();		
		xstream.alias("xml", mt.getClass());
		return xstream.toXML(mt);
	}
	
	
	
}
