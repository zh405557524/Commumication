package com.soul.commumication.utils.basicutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 * @描述 MD5 加密工具
 *
 *　svn author：$Author: heima09 $
 *  svn version: $Rev: 142 $
 *  svn update time: $Date: 2015-07-29 11:29:41 +0800 (Wed, 29 Jul 2015) $
 */
public class Md5Utils {
	
	/**
	 * @param filePath
	 *      文件的路径
	 * @return
	 * 	该文件的md5
	 * 
	 */
	public static String getFileMD5(String filePath){
		StringBuilder res = new StringBuilder("");
		try {
			MessageDigest instance = MessageDigest.getInstance("md5");
			
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024 *10];
			int len = fis.read(buffer);
			while (len != -1) {
				instance.update(buffer, 0, len);
				len = fis.read(buffer);
			}
			
			
			//传递要加密的字符串的数组，返回MD5值的数组
			byte[] digest = instance.digest();
			for (byte b : digest) {
				//一个字节 转成十六进制数输出
				//打印对象 调用该对象toString
				
				//System.out.println(b && 0xff);
				String hex = Integer.toHexString(b & 0xff);
				if (hex.length() == 1)
					hex = "0" + hex;
				
				res.append(hex.toUpperCase());
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res + "";
	}
	/**
	 * @param text
	 *    要加密的字符串
	 * @return
	 *    MD5值
	 */
	public static String md5String(String text){
		StringBuilder res = new StringBuilder("");
		try {
			MessageDigest instance = MessageDigest.getInstance("md5");
			//传递要加密的字符串的数组，返回MD5值的数组
			byte[] digest = instance.digest(text.getBytes());
			for (byte b : digest) {
				//一个字节 转成十六进制数输出
				//打印对象 调用该对象toString
				
				//System.out.println(b && 0xff);
				String hex = Integer.toHexString(b & 0xff);
				if (hex.length() == 1)
					hex = "0" + hex;
				
				res.append(hex);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res + "";
	}
}
