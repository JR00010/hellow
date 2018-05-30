package com.frame.test;

import java.io.File;
import java.text.Annotation;
import java.text.Collator;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineTest {
	public static void main(String[] args) throws Exception {
//		  ScriptEngineManager factory = new ScriptEngineManager();//step 1
//	        ScriptEngine engine = factory.getEngineByName("JavaScript");//Step 2        
//		engine.eval("print(1+2)");//Step 3
		
		 // Compare two strings in the default locale
		 Collator myCollator = Collator.getInstance();
		 if( myCollator.compare("ABC", "ABC") < 0 )
		     System.out.println("abc is less than ABC");
		 else
		     System.out.println("abc is greater than or equal to ABC");

		 System.err.println(myCollator.equals("123","123"));
		
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        testScriptVariables(engine);//演示如何暴露Java对象为脚本语言的全局变量
//         testInvokeScriptMethod(engine);//演示如何在Java中调用脚本语言的方法
//         testScriptInterface(engine);//演示脚本语言如何实现Java的接口
//         testUsingJDKClasses(engine);//演示脚本语言如何使用JDK平台下的类
	}
	
	public static void testScriptVariables(ScriptEngine engine) throws ScriptException{
        File file = new File("test.txt");
        engine.put("f", file);
        engine.eval("print('Total Space:'+f.getTotalSpace())");        
    }
    
    public static void testInvokeScriptMethod(ScriptEngine engine) throws Exception{
        String script = "function hello(name) { return 'Hello,' + name;}";
        engine.eval(script);
        Invocable inv = (Invocable) engine;
        String res = (String)inv.invokeFunction("hello", "Scripting" );
        System.out.println("res:"+res);
    }
    
    public static void testScriptInterface(ScriptEngine engine) throws ScriptException{
        String script = "var obj = new Object(); obj.run = function() { print('run method called'); }";
        engine.eval(script);
        Object obj = engine.get("obj");
        Invocable inv = (Invocable) engine;
        Runnable r = inv.getInterface(obj,Runnable.class);
        Thread th = new Thread(r);
        th.start();
    }
    
    public static void testUsingJDKClasses(ScriptEngine engine) throws Exception{
        //Packages是脚本语言里的一个全局变量,专用于访问JDK的package
        String js = "function doSwing(t){var f=new Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";
        engine.eval(js);
        Invocable inv = (Invocable) engine;
        inv.invokeFunction("doSwing", "Scripting Swing" );
    }
}
