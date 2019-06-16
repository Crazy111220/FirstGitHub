package com.kgc.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

public class AESUtil {

	/*
	 * 加密
	 * 1.构造密钥生成器
	 * 2.根据ecnodeRules规则初始化密钥生成器
	 * 3.产生密钥
	 * 4.创建和初始化密码器
	 * 5.内容加密
	 * 6.返回字符串
	 */
	public static String AESEncode(String encodeRules,String content){
		try {
			//1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen=KeyGenerator.getInstance("AES");
			//2.根据ecnodeRules规则初始化密钥生成器
			//生成一个128位的随机源,根据传入的字节数组
			keygen.init(128, new SecureRandom(encodeRules.getBytes()));
			//3.产生原始对称密钥
			SecretKey original_key=keygen.generateKey();
			//4.获得原始对称密钥的字节数组
			byte [] raw=original_key.getEncoded();
			//5.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(raw, "AES");
			//6.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte [] byte_encode=content.getBytes("utf-8");
			//9.根据密码器的初始化方式--加密：将数据加密
			byte [] byte_AES=cipher.doFinal(byte_encode);
			//10.将加密后的数据转换为字符串
			//这里用Base64Encoder中会找不到包
			//解决办法：
			//在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
			String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
			//11.将字符串返回
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//如果有错就返加nulll
		return null;
	}

	/*
	 * 解密
	 * 解密过程：
	 * 1.同加密1-4步
	 * 2.将加密后的字符串反纺成byte[]数组
	 * 3.将加密内容解密
	 */
	public static String AESDncode(String encodeRules,String content){
		try {
			//1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen=KeyGenerator.getInstance("AES");
			//2.根据ecnodeRules规则初始化密钥生成器
			//生成一个128位的随机源,根据传入的字节数组
			keygen.init(128, new SecureRandom(encodeRules.getBytes()));
			//3.产生原始对称密钥
			SecretKey original_key=keygen.generateKey();
			//4.获得原始对称密钥的字节数组
			byte [] raw=original_key.getEncoded();
			//5.根据字节数组生成AES密钥
			SecretKey key=new SecretKeySpec(raw, "AES");
			//6.根据指定算法AES自成密码器
			Cipher cipher=Cipher.getInstance("AES");
			//7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.DECRYPT_MODE, key);
			//8.将加密并编码后的内容解码成字节数组
			byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
			/*
			 * 解密
			 */
			byte [] byte_decode=cipher.doFinal(byte_content);
			String AES_decode=new String(byte_decode,"utf-8");
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		//如果有错就返加nulll
		return null;
	}


	public static void main(String[] args) {
//	    	SymmetricEncoder se=new SymmetricEncoder();
//
//	    	String key = "ABDKDAD";
//	    	String content = "我是外星人";
//
//	    	String encode = se.AESEncode(key, content);
//	    	System.out.println("encode:" + encode);
//
//	    	String dncode = se.AESDncode(key,"m5PHFVipOAdyULvfr9ScsNg==");
//	    	System.out.println("dncode:" + dncode);
//
////	    	for(int i=0; i<5000; i++) {
////	    		encode();
////	    	}

		login_getLoginUser();

	}

	public static void encode() {
		AESUtil se=new AESUtil();

		long beginTime = System.currentTimeMillis();
		String key = UUID.randomUUID().toString();
		String content =(Math.random() * 100000) + "|" + (Math.random() * 10000000);
		System.out.println(content);
		String encode = se.AESEncode(key, content);
		System.out.println("encode time :" + (System.currentTimeMillis() - beginTime) + "," + encode);
	}

	public static void dncode() {
		AESUtil se=new AESUtil();

		String key = UUID.randomUUID().toString();
		String content = UUID.randomUUID().toString() + (Math.random() * 10000);
		String encode = se.AESEncode(key, content);

		long beginTime = System.currentTimeMillis();
		se.AESDncode(key,encode + "aaaff");

		System.out.println("dncode time :" + (System.currentTimeMillis() - beginTime));

	}


	public static void login_getLoginUser() {
		User user = new User();
		user.setId(88);
		user.setSalt("a8oPut");
		Date date = new Date();
		user.setCreateTime(date);

		//login 时 第一次加密
		String authKey = AESUtil.AESEncode(user.getSalt(), user.getCreateTime().toString());
		System.out.println("authKey =>" + authKey);

		//login 完整加密串，放入cookies
		String signToken =  AESUtil.AESEncode("HP_HOME", user.getId() + "|" + authKey);
		System.out.println("signToken =>" + signToken);


		//登陆恢复时第一次解密, 88|******
		String token = AESUtil.AESDncode("HP_HOME", signToken);
		System.out.println("token =>" + token);

		//获得明文token中的[0]userid，拿到user对像，得到salt，再加密后与[1]比较
		//SymmetricEncoder.AESEncode(user.getSalt(), user.getCreateTime().toString()) == [1];


		System.out.println(Base64.encode(UUID.randomUUID().toString()));


	}



	private static class User{

		private int id;

		private String salt;

		private Date createTime;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}







	}


}
