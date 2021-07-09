package com.iwhale.dynamic.util;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;


/**
 * Base64类 <br>
 * 功能：字符串的BASE64编码解码。
 */
public class Base64 {

	private static final String KEY_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
	public static final String passwkey="1EA89BF48C870AF3F46002402315A777";
	/**
	 * 将字符串转化为base64编码
	 *
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getBase64(String s)
			throws UnsupportedEncodingException {
		if(StringUtil.isEmpty(s)) {
			s = "";
		}
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(s
				.getBytes("utf-8"));
		return new String(bytes, "utf-8");

	}

	/**
	 * 将 BASE64 编码的字符串 s 进行解码
	 *
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getFromBase64(String s)
			throws UnsupportedEncodingException {
		if(s!=null){
			byte[] bytes = s.getBytes("utf-8");
			byte[] convertBytes = org.apache.commons.codec.binary.Base64
					.decodeBase64(bytes);
			return new String(convertBytes, "utf-8");
		}
		return  "";
	}

	/**
	 * 将Base64编码的字符串解码
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] decodeBase64(String s){
		if(s!=null){
			byte[] bytes;
			try {
				bytes = s.getBytes("utf-8");
				byte[] convertBytes = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
				return convertBytes;
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		}
		return null;
	}

	/**
	 * Java、C#双语版配套AES解密
	 * @param str
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String aesDecrypt(String str, String key) throws Exception {
		if (str == null || key == null) {
			return null;
		}
		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
		byte[] bytes = new BASE64Decoder().decodeBuffer(str);
		bytes = cipher.doFinal(bytes);
		return new String(bytes, "utf-8");
	}
}
