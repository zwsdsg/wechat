package com.wechat.voice.dao;

import java.util.List;

import com.wechat.voice.pojo.VoiceBeans;

public interface Book {

	//根据书名检索显示图书信息
	public List<VoiceBeans> getBookInfoByName(String name);
}
