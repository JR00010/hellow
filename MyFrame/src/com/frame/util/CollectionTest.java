package com.frame.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
//import java.util.ResourceBundle.Control;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

import com.frame.mcv.controller.book;
import com.frame.mcv.controller.book.Control;

public class CollectionTest {
	public static void main(String[] args) {
//		DequeTest();
//	      test1(-5);
	        test2(5);
//		MapTest();
//		WhichChars("How do you do");
//		used.set(56);
//		System.err.println(used.get(32));
//        System.out.println(used);
//        
//        
//        HashSet<String> h  = new HashSet<String>();
//        h.add("9");
//        h.add("3");
//        h.add("4");
//        h.add("7");
//        h.clear();
//        System.err.println(h);
//        
//        
//        Runtime r = Runtime.getRuntime();
//        Process p = null;
//        try{
//            p = r.exec("D:/Program Files/360Chrome/Chrome/Application/360chrome.exe");
//            p.waitFor();
//        } catch (Exception e) {
//            System.out.println("Error executing notepad.");
//        }
//        System.out.println("Notepad returned " + p.exitValue());
//	        String name = "abner chai";
	         String name = null;
	         assert (name!=null):"±äÁ¿nameÎª¿Õnull";
	         System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        
	}
	
	public static void DequeTest(){
		ArrayDeque<String> ad = new ArrayDeque<String>();
		ad.addFirst("q");
		ad.addFirst("b");
		ad.addFirst("c");
		ad.addFirst("d");
		String[] s = new String[64];
		int head = 0;
		for (int i = 0; i < s.length; i++) {
//			 s[head = (head - 1) & (s.length - 1)]=""+i;
			 s[s.length - 1-i] =""+i;
			 System.err.println(head);
		}
		
		System.err.println(Arrays.toString(s));
		
//		s[head = (2 - 1) & (s.length - 1)] = "dsadsad";
//		
//		int tail =0;
//		
//		tail  = (8) | (13);
//		
//		System.err.println(tail);
//		System.err.println(Arrays.toString(s));
	}
	
    private static void test1(int a){
        assert a > 0;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
    
    
    public static void MapTest() {
    	ConcurrentSkipListMap<Integer, String> m = new ConcurrentSkipListMap<Integer,String>();
    	int i = 0;
    	java.util.ResourceBundle.Control c = new ResourceBundle.Control() {
    		public void get(){
    			System.err.println("sssss");
    		}
		};
	}
    
    
    private static BitSet used = new BitSet();
    public static  void WhichChars(String str){
       for(int i=0;i< str.length();i++)
         used.set(str.charAt(i));  // set bit for char
    }
     public String toString(){
          String desc="[";
          int size=used.size();
           for(int i=0;i< size;i++){
              if(used.get(i))
                  desc+=(char)i;
             }
              return desc+"]";
          }

}
