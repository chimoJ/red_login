package com.imooc.utils;

import java.util.UUID;

//文件上传的工具类
public class UploadUtils {
//产生一个随机并唯一的文件名
	public static String getUUIDFileName(String fileName) {
		//将文件名前部进行截取：xx.jpg 只取.jpg
		int index= fileName.indexOf('.');
		String extension=fileName.substring(index);
		return UUID.randomUUID().toString().replace("-", "")+extension;
	}
	public static void main(String[] args) {
       System.out.println(getUUIDFileName("123.jpg"));
	}
}
