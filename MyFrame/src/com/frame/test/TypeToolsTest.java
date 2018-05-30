package com.frame.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.frame.converter.Converter;
import com.frame.mcv.controller.book;
import com.frame.mcv.service.ConvertServiceimpl;
import com.frame.sun.www;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/** 类型识别工具测试类 
 * @author cxy @ www.cxyapi.com 
 */  
public class TypeToolsTest  
{  


	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException  
    {  
        int i=0;  
        TypeObject to=new TypeObject();  
        //1.反射  
        System.out.println("to的类型:"+to.getClass().getSimpleName());  
        System.out.println(int.class);  
        System.out.println(Integer.class.getSimpleName()); 
        //但是对于一个不确定类型的基本数据类型变量我们没法用反射来获取其类型。  
        System.out.println("----------------------");  
          
        //2.instanceof  
        if(to instanceof TypeObject){ System.out.println("to是TypeObject类型的");}  
        //但是这种办法貌似也没法确定基本数据类型  
        System.out.println("----------------------");  
          
        //以上两种方式对于对象，引用类型的都很好用，但是对基本数据类型就不那么好用了。  
        //3.通过多态(方法的重载)  
        System.out.println("i是："+TypeTools.getType(i));  
        System.out.println("to是："+TypeTools.getType(to));  
        System.out.println("\"cxyapi\"是："+TypeTools.getType("www.cxyapi.com"));  
        //大家可以看出来 最后一种方式使用多态的方式达到了检测类型(基本类型和引用类型)的目的  
        //它除了弥补其他两种方式不能检测基本数据类型的不足在外，还能自己DIY类型信息  
        System.err.println(Integer.class.isInstance(9)+"33333");
         if (ArrayList.class.newInstance() instanceof List) {
        	 List new_name = (List) ArrayList.class.newInstance();
			
		} 
        to.getClass().isInstance(to);
        
//        
        System.out.println(Integer.TYPE);
        System.err.println(isJavaClass(String[].class)+"+++++++++");
        System.err.println(int.class.getTypeName());
        System.err.println(Integer.class.getTypeName());
        String s= "sssss";
        System.err.println(s.substring(s.indexOf(".")+1));
        ArrayList<String > d = new ArrayList<String>();
        System.err.println(((ParameterizedType)d.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());
        
        
        book ge = new book();
//        Field f = ge.getClass().getDeclaredField("list");
//        Type type = f.getGenericType();
//        ParameterizedType pt  = (ParameterizedType)type;
//        System.out.println((Class<?>)pt.getActualTypeArguments()[0]);
        

        //方法入参泛型类型
        Method m = ge.getClass().getMethod("get3", ArrayList.class);
        Class<?>[] v= m.getParameterTypes();
        
        System.err.println(v[0].getName()+"///////////////");
        Type[] types = m.getGenericParameterTypes();
        System.err.println(types[0].getClass().getName()+"/////////");
        ParameterizedType ptt = (ParameterizedType)types[0];
        
        System.out.println(ptt.getRawType());
        System.out.println(ptt.getOwnerType());
        System.out.println(ptt.getActualTypeArguments()[0]);
//        Method[] m1 = ge.getClass().getDeclaredMethods();
//        for (Method method : m1) {
//        	Parameter[] t = method.getParameters();
//        	for (int j = 0; j < t.length; j++) {
//				System.err.println(t[i].getName());
//			}
//        	
//		}
        
        
    }  
    
    
	private static boolean isJavaClass(Class<?> clz) {  
	    return clz != null && clz.getClassLoader() == null;  
}
}  
  
//定义一个类，为了演示引用类型的类型检测  
class TypeObject{}  

 class TypeTools  
{  
    //获得类型  
    public static Map<String,String> getType(Object o)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", o.getClass().getSimpleName());  
        typeInfo.put("描述", "引用类型");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(int i)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "int");  
        typeInfo.put("描述", "整形");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(long l)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "long");  
        typeInfo.put("描述", "长整型");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(boolean b)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "boolean");  
        typeInfo.put("描述", "布尔类型");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(char b)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "char");  
        typeInfo.put("描述", "字符");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(float f)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "float");  
        typeInfo.put("描述", "单精度浮点型");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(double d)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "double");  
        typeInfo.put("描述", "双精度浮点型");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(String s)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("类型", "String");  
        typeInfo.put("描述", "字符串类型");  
        return typeInfo;  
    } 
    
    public static <T> Converter<String, ?>  getConverter(Class<?> clz){
		return null;
    	
    }
      
}  