package com.ggstudy.logic.security;

import java.util.Base64;

/**
 * 从加解密的角度讲，私钥公钥是都可以用来加解密的；</br>
 * 然而业务上：</br>
 * 加解密时：公钥加密，私钥解密；</br>
 * 签名时：私钥签名，公钥验证
 * 
 * @author xcj
 *
 */
public class RSATest {
	public static String data = "hello world";
	static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmrFIPYdbjP1MG3PKymMn6+LmUMfcewsJESdfH+c6hWa4qSs6mrZ3bEatI5Alq/3IUH7wDbBsFh4vE1LecQrNVVoLbq3lGY4tN5/GKzXPXPaRI5fJNSrBTXT4pbmAnYMSHNaUydnaQuMGi0OiFpHhYKn4tFPRxYXbC8Ni/dGnp9wIDAQAB";
	static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKasUg9h1uM/Uwbc8rKYyfr4uZQx9x7CwkRJ18f5zqFZripKzqatndsRq0jkCWr/chQfvANsGwWHi8TUt5xCs1VWgtureUZji03n8YrNc9c9pEjl8k1KsFNdPiluYCdgxIc1pTJ2dpC4waLQ6IWkeFgqfi0U9HFhdsLw2L90aen3AgMBAAECgYEAkYLgIY3JjZw7YEKFoGbD79g2LKtyk+h0sinFuVDelP82jrXAtMPejONgJsLvdfqOHgOWoWZAMROlcrJDmqig5u9smfswPAkL8qpdcKa/7RqoMB22TbmIVI9qrXESUMnQSsPpZUt39lY7gNTU/1I/iJkWgN/xCVnIbNF0bdDWwAECQQD++EVZTJLl4FqotW3RIzlUyEVFkDfA/l7eB1tHXoJUmW1j9xILQao1fNbvA64YNCdKBAyc4vNfQV1XQkl3Zfy3AkEAp1i4OBIcCjtKoM8tk0rNCfstsa3GAQF/jveJBFvWdficTkwCZsfKrEfX1g5F555Fq6Yb7hvnDUv9QGIPvJC8wQJAGqRWmr4lm1+WGYrbrr6/ftxuYJZxPPlXcFvUbeCyPaTKiWeHuyVhY7VnwBHiXyUT9ef2aW5Nf+aUmkmS46cEgQJAMHZV6w77hc8D3qwA083usPxHkFP1qmbnrNxslpGN+t4DTf1fGKq1O80WaUv63IeOP5Y8MmlsMQKXlaSQUBhOQQJBAL7MzlVZMZqO/jm/QjMc1KpCxcYuTE5l45PMFQVhiDP3C1H1tktuw6mpvglVJ1sviOn6PQS0sKmVEnMzQxgmi8c=";

	public static void main(String[] args) {
		// JavaRSAUtils.genKeyPair();
		try {
			byte[] bb = JavaRSAUtils.encryptByPublicKey(data.getBytes(), publicKey);
			String bbStr=new String(Base64.getEncoder().encode(bb));
			System.out.println("bbStr："+bbStr);
			
			String cc = new String(JavaRSAUtils.decryptByPrivateKey(Base64.getDecoder().decode(bbStr.getBytes()), privateKey));
			System.out.println("公钥加密私钥解密的结果：" + cc);

			byte[] bbb = JavaRSAUtils.encryptByPrivateKey(data.getBytes(), privateKey);
			String ccc = new String(JavaRSAUtils.decryptByPublicKey(bbb, publicKey));
			System.out.println("私钥加密公钥解密的结果：" + ccc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
