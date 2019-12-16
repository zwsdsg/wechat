package com.wechat.getToken;

public interface GetAccess_token {

	/*从微信获取json数据格式保存到数据库，每个7200（2小时）秒自动执行一次
	 * param:
	 * appid：微信id
	 * appsecret:微信秘钥
	 * 微信本身还需要传入grant_type填写client_credential
	 * */
	public void getTokenFromWechat(String appId, String appSecret);
	
	
	
	/*本地获取access_token方法
	 * */
	public void getTokenByid(String appId);
	
	
	
}
