package com.frame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class StringUtill {
	public static String StringToWord(String str){
		char c = str.charAt(0);
		String frontChar =  (c+"").toUpperCase();
		String newString = str.replaceFirst(c+"", frontChar);
		return newString.replace(" ", "");
		
	}
	/**字符串为“”或者是null 则返回true
	 * @param str
	 * @return
	 */
	public  static Boolean  isBank(String str){
		Boolean flag = false;
		if(Objects.equals("", str)||str==null){
			flag = true ;
		}
		return flag;
	}
	public static void main(String[] args) throws IOException {
//		System.err.println(StringToWord("bfdsaf af d "));
//		
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("1", "asd");
//		System.err.println(map.remove("1"));
		
//		testBuffer();
//		channeltest();
		
		
//		 FileInputStream fis = null;
//	        FileOutputStream fos = null;
//	        // 定义两个直连的文件管道
//	        FileChannel in = null, out = null;
//	        fis = new FileInputStream(new File("src/config/aa.txt"));
//	        fos = new FileOutputStream(new File("src/config/aa1.txt"));
//	        
//	        in = fis.getChannel();
//	        out = fos.getChannel();
//	        // 直接让流流向要拷贝的文件
//	        out.transferFrom(in, 0, in.size());
//	        in.close();
//	        out.close();
//	        fis.close();
//	        fos.close();
	        
	        
	        
//	    	RandomAccessFile fromFile = new RandomAccessFile("src/config/aa.txt", "rw");
//			FileChannel      fromChannel = fromFile.getChannel();
//			
//			RandomAccessFile toFile = new RandomAccessFile("src/config/aa1.txt", "rw");
//			FileChannel      toChannel = toFile.getChannel();
//
//			long position = 0;
//			long count = fromChannel.size();
//
//			toChannel.transferFrom(fromChannel, count, position);
//			fromChannel.close();
//			toChannel.close();
//			fromFile.close();
//			toFile.close();
			
			
			
//			RandomAccessFile fromFile = new RandomAccessFile("src/config/aa.txt", "rw");
//			FileChannel      fromChannel = fromFile.getChannel();
//
//			RandomAccessFile toFile = new RandomAccessFile("src/config/aa1.txt", "rw");
//			FileChannel      toChannel = toFile.getChannel();
//
//			long position = 0;
//			long count = fromChannel.size();
//
//			fromChannel.transferTo(position, count, toChannel);
			
		
	}
	public static void  testNio() throws IOException{
		File f =  new File("src/config/aa.txt");
		InputStreamReader InputStreamReader = new InputStreamReader(new FileInputStream(f),"UTF-8") ;
		
		RandomAccessFile aFile = new RandomAccessFile("src/config/aa.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		 
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
//				System.out.print((char) buf.get());
			     //转换为数组
			     byte[] bytes=new byte[buf.limit() ];
			     buf.get(bytes);
			     //转换为String变量
			     
			     String msg=new String(bytes);
			     System.out.print(msg);
			}
			buf.compact();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
	public static void  channeltest() throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("src/config/aa.txt", "rw");
		FileChannel      fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("src/config/aa1.txt", "rw");
		FileChannel      toChannel = toFile.getChannel();

		long position = 0;
		long count = fromChannel.size();

		toChannel.transferFrom(fromChannel, count, position);
		
	}
	public static String bytesToHexString(byte[] src){

	    StringBuilder stringBuilder = new StringBuilder("");
	    if (src == null || src.length <= 0) {
	        return null;
	    }
	    for (int i = 0; i < src.length; i++) {
	        int v = src[i] & 0xFF;
	        String hv = Integer.toHexString(v);
	        if (hv.length() < 2) {
	            stringBuilder.append(0);
	        }
	        stringBuilder.append(hv);
	    }
	    return stringBuilder.toString();

	}
	
	public static void  testBuffer() {

	    System.out.println("----------Test allocate--------");  
	    System.out.println("before alocate:"  
	            + Runtime.getRuntime().freeMemory());  
	      
	    // 如果分配的内存过小，调用Runtime.getRuntime().freeMemory()大小不会变化？  
	    // 要超过多少内存大小JVM才能感觉到？  
	    ByteBuffer buffer = ByteBuffer.allocate(102400);  
	    System.out.println("buffer = " + buffer);  
	      
	    System.out.println("after alocate:"  
	            + Runtime.getRuntime().freeMemory());  
	      
	    // 这部分直接用的系统内存，所以对JVM的内存没有影响  
	    ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);  
	    System.out.println("directBuffer = " + directBuffer);  
	    System.out.println("after direct alocate:"  
	            + Runtime.getRuntime().freeMemory());  
	      
	    System.out.println("----------Test wrap--------");  
	    byte[] bytes = new byte[32];  
	    buffer = ByteBuffer.wrap(bytes);  
	    System.out.println(buffer);  
	      
	    buffer = ByteBuffer.wrap(bytes, 10, 10);  
	    System.out.println(buffer);
		
	}
}
