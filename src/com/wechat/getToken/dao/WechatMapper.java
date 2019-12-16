package com.wechat.getToken.dao;

import java.util.List;

import com.wechat.beans.RuleOfAutoReply;
import com.wechat.beans.WechatInfo;

public interface WechatMapper {

	public void addWecahtInfo(WechatInfo wechatInfo);
	
	public void addRuleOfReply(RuleOfAutoReply roar);
	
	public List<String> getAllKeyword();
	
	public String getReplyTextbykey(String key);
}
