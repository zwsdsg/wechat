package com.wechat.getToken.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.beans.RuleOfAutoReply;
import com.wechat.beans.WechatInfo;

@Controller
public class GetwechatInfo {

	
	private SqlSession getSqlSession() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory.openSession();
	}
	
	@RequestMapping("/getwechatInfo")
	public void addToken(WechatInfo wechatInfo) throws IOException{
		SqlSession sqlSession = getSqlSession();
		WechatMapper mapper = sqlSession.getMapper(WechatMapper.class);
		try{
			mapper.addWecahtInfo(wechatInfo);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	
	
	@RequestMapping(value="/addRuleOfReply")
	public void addRuleOfReply(RuleOfAutoReply roar) throws IOException{
		SqlSession sqlSession = getSqlSession();
		WechatMapper mapper = sqlSession.getMapper(WechatMapper.class);
		mapper.addRuleOfReply(roar);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	public String getReply(String content) throws IOException{
		
		SqlSession sqlSession = getSqlSession();
		WechatMapper mapper = sqlSession.getMapper(WechatMapper.class);
		List<String> keys = mapper.getAllKeyword();
		System.out.println(keys);
		for(String key:keys){
			if(Pattern.matches(key, content)){
				String replytext = mapper.getReplyTextbykey(key);
				sqlSession.commit();
				sqlSession.close();
				return replytext;
			}
		}return "";
	}
	
}
