package com.wechat.beans;

public class RuleOfAutoReply {
	private String key;
	private String replyText;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public RuleOfAutoReply(String key, String replyText) {
		super();
		this.key = key;
		this.replyText = replyText;
	}
	public RuleOfAutoReply() {
		super();
	}
	@Override
	public String toString() {
		return "RuleOfAutoReply [key=" + key + ", replyText=" + replyText + "]";
	}	
}
