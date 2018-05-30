package com.frame.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import javax.swing.text.html.CSS;
import javax.swing.text.html.CSS.Attribute;
import javax.swing.text.html.HTML;

import jdk.nashorn.internal.parser.JSONParser;

public class JsonTest {
	
	public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException {
		
		String init = read(JsonTest.class.getResource("/config/json2java.js"));
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		engine.eval(init);
//		ScriptEngine jsonParser = engine;
//		
//		
//		
		Bindings bindings = new SimpleBindings();
//		String json = "{name:'jr'}";
//		String eval = "var tmp = " + "4564" + ";var o =toJava();";
//		engine.eval(eval, bindings);
//		Object result = engine.eval(eval, bindings); 
		
		System.err.println(HTML.Tag.A.toString());
		Attribute[] s = CSS.getAllAttributeKeys();
		System.err.println(Arrays.toString(s));
		Attribute d = CSS.getAttribute("color ");
		System.err.println(d.getDefaultValue());
//		String script = "var obj = new Object(); var o = obj.toJava()";
//		
//		System.err.println(engine.eval(script, bindings));
//		 Invocable inv = (Invocable) engine;
//		 Object o =  inv.invokeFunction("toJava", "toJava" );
//		 System.err.println(o);
//		 System.err.println(bindings.get("o"));
////		AtomicReference ret = (AtomicReference) bindings.get("o");
//		
////		ret.get();
//		System.err.println(result);
		
		
		
//		String str = "(a or b) and c";
//        str = str.replaceAll("or", "||");
//        str = str.replaceAll("and", "&&");
//        System.out.println(str);
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("js");
//        engine.put("a",true);
//        engine.put("b",false);
//        engine.put("c",true);        
//        Object result = engine.eval(str);
//        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
		
		
        
        
        
        
		
//	    try {    
//            new JsonTest().greet();    
//        } catch (ScriptException ex) {    
////            Logger.getLogger(BasicScripting.class.getName()).log(Level.SEVERE, null, ex);    
//        }
//	    
//	    
//	    try{  
//	        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");  
//	        Compilable compilable = (Compilable) engine;  
//	        Bindings bindings = engine.createBindings(); // Local级别的Binding  
//	        String script = "function add(op1,op2){return op1+op2} add(a, b)"; // 定义函数并调用  
//	        CompiledScript JSFunction = compilable.compile(script); // 解析编译脚本函数  
//	        bindings.put("a", 1);  
//	        bindings.put("b", 2); // 通过Bindings加入参数  
//	        Object result = JSFunction.eval(bindings);  
//	        System.out.println(result); //调用缓存着的脚本函数对象，Bindings作为参数容器传入  
//	        }catch (ScriptException e) {  
//	           
//	        }  
//	    
//	    
//	    ScriptEngineManager manager = new ScriptEngineManager();  
//        ScriptEngine engine = manager.getEngineByName("js");  
//        SimpleBindings simpleBindings = new SimpleBindings();  
//        String jsCript = "for(var i=0; i<test.length; i++){test[i] = test[i].replaceAll(',' , '')} ; test";  
//        simpleBindings.put("test", Arrays.asList("1,2,37", "1,223", "3,932"));  
//        Object result = engine.eval(jsCript, simpleBindings);  
//        System.out.println(result); 
	}
	public static String read(URL path) throws IOException{
		
		Reader fr = new InputStreamReader(path.openStream());
		char data[]=new char[1024];
		 int num=fr.read(data);
		    // 将字符列表转换成字符串
		    String str=new String(data,0,num);
//		    // 输出在控制台
//		    System.out.println("Characters read= "+num);
//		    System.out.println(str);
		    fr.close();
		return str;
	}
	
    public void greet() throws ScriptException {    
        ScriptEngineManager manager = new ScriptEngineManager();    
        ScriptEngine engine = manager.getEngineByName("JavaScript");    
        //ScriptEngine engine = manager.getEngineByExtension("js");    
        //ScriptEngine engine = manager.getEngineByMimeType("text/javascript");    
        if (engine == null) {    
            throw new RuntimeException("找不到JavaScript语言执行引擎。");    
        }    
        engine.eval("println('Hello!');");    
    }    
      
    
}
