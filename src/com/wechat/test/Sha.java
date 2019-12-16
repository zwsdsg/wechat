package com.wechat.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Sha {

	@Test
	public void testSha() throws NoSuchAlgorithmException{
		String str = "shui620918";
		byte[] inputData = str.getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(inputData);
		BigInteger sha = new BigInteger(md.digest());
		System.out.println(sha.toString(32));
		
	}
}
