package com.ggstudy.logic.security;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

/**
 * @author xcj 用java.security实现rsa加解密
 */
public class JavaRSAUtils {
	

	/**
	 * 公钥加密
	 * 
	 * @param content
	 * @param publicKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] content, String publicKeyStr) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKeyStr);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		Key publicK = keyFactory.generatePublic(x509EncodedKeySpec);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		return cipher.doFinal(content);
	}

	/**
	 * 私钥解密
	 * 
	 * @param content
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] content, String privateKeyStr) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKeyStr);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		return cipher.doFinal(content);
	}

	// ==========================================================================================
	/**
	 * 私钥加密
	 * 
	 * @param content
	 * @param publicKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] content, String privateKeyStr) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKeyStr);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		return cipher.doFinal(content);
	}

	/**
	 * 公钥解密
	 * 
	 * @param content
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] content, String publicKeyStr) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKeyStr);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);

		Key publicK = keyFactory.generatePublic(x509EncodedKeySpec);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		return cipher.doFinal(content);
	}

	/**
	 * @return 生成字符串形式的秘钥对
	 */
	public static Map<String, String> genKeyPair() {
		Map<String, String> keyMap = new HashMap<String, String>(2);
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			keyMap.put("PUBLIC_KEY", new String(Base64.getEncoder().encode(publicKey.getEncoded())));
			keyMap.put("PRIVATE_KEY", new String(Base64.getEncoder().encode(privateKey.getEncoded())));

			System.out.println("公钥：" + keyMap.get("PUBLIC_KEY"));
			System.out.println("私钥：" + keyMap.get("PRIVATE_KEY"));
			return keyMap;
		} catch (Exception ex) {

		}
		return keyMap;
	}

}
