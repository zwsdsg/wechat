package com.wechat.getToken;

public interface GetAccess_token {

	/*��΢�Ż�ȡjson���ݸ�ʽ���浽���ݿ⣬ÿ��7200��2Сʱ�����Զ�ִ��һ��
	 * param:
	 * appid��΢��id
	 * appsecret:΢����Կ
	 * ΢�ű�����Ҫ����grant_type��дclient_credential
	 * */
	public void getTokenFromWechat(String appId, String appSecret);
	
	
	
	/*���ػ�ȡaccess_token����
	 * */
	public void getTokenByid(String appId);
	
	
	
}
