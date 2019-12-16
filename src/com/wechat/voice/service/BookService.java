package com.wechat.voice.service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechat.voice.dao.Book;
import com.wechat.voice.pojo.VoiceBeans;

@Controller
public class BookService {

	@RequestMapping("/getBookInfoByName")
	@ResponseBody
	public String getBookInfoByName(String name) throws IOException{
		System.out.println("开启查询模式");
		SqlSession sqlSession = getSqlSession();
		Book book = sqlSession.getMapper(Book.class);
		List<VoiceBeans> voiceBeans = book.getBookInfoByName(name);
		return voiceBeans.toString();
	}
	
	//载入配置文件
	private SqlSession getSqlSession() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		System.out.println("载入配置文件");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory.openSession();
	}
	
	
	
	
}
