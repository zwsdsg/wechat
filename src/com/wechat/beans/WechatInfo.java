package com.wechat.beans;

public class WechatInfo {

	private String appId;
	private String appSecret;
	private boolean qrCode;
	private String isIdentification;
	private String token;
	private String wechatName;
	public String getWechatName() {
		return wechatName;
	}
	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public boolean isQrCode() {
		return qrCode;
	}
	public void setQrCode(boolean qrCode) {
		this.qrCode = qrCode;
	}
	public String getIsIdentification() {
		return isIdentification;
	}
	public void setIsIdentification(String isIdentification) {
		this.isIdentification = isIdentification;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
