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

/** ����ʶ�𹤾߲����� 
 * @author cxy @ www.cxyapi.com 
 */  
public class TypeToolsTest  
{  


	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException  
    {  
        int i=0;  
        TypeObject to=new TypeObject();  
        //1.����  
        System.out.println("to������:"+to.getClass().getSimpleName());  
        System.out.println(int.class);  
        System.out.println(Integer.class.getSimpleName()); 
        //���Ƕ���һ����ȷ�����͵Ļ����������ͱ�������û���÷�������ȡ�����͡�  
        System.out.println("----------------------");  
          
        //2.instanceof  
        if(to instanceof TypeObject){ System.out.println("to��TypeObject���͵�");}  
        //�������ְ취ò��Ҳû��ȷ��������������  
        System.out.println("----------------------");  
          
        //�������ַ�ʽ���ڶ����������͵Ķ��ܺ��ã����ǶԻ����������;Ͳ���ô�����ˡ�  
        //3.ͨ����̬(����������)  
        System.out.println("i�ǣ�"+TypeTools.getType(i));  
        System.out.println("to�ǣ�"+TypeTools.getType(to));  
        System.out.println("\"cxyapi\"�ǣ�"+TypeTools.getType("www.cxyapi.com"));  
        //��ҿ��Կ����� ���һ�ַ�ʽʹ�ö�̬�ķ�ʽ�ﵽ�˼������(�������ͺ���������)��Ŀ��  
        //�������ֲ��������ַ�ʽ���ܼ������������͵Ĳ������⣬�����Լ�DIY������Ϣ  
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
        

        //������η�������
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
  
//����һ���࣬Ϊ����ʾ�������͵����ͼ��  
class TypeObject{}  

 class TypeTools  
{  
    //�������  
    public static Map<String,String> getType(Object o)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", o.getClass().getSimpleName());  
        typeInfo.put("����", "��������");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(int i)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "int");  
        typeInfo.put("����", "����");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(long l)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "long");  
        typeInfo.put("����", "������");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(boolean b)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "boolean");  
        typeInfo.put("����", "��������");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(char b)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "char");  
        typeInfo.put("����", "�ַ�");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(float f)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "float");  
        typeInfo.put("����", "�����ȸ�����");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(double d)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "double");  
        typeInfo.put("����", "˫���ȸ�����");  
        return typeInfo;  
    }  
      
    public static Map<String,String> getType(String s)  
    {  
        Map<String,String> typeInfo=new HashMap<String,String>();  
        typeInfo.put("����", "String");  
        typeInfo.put("����", "�ַ�������");  
        return typeInfo;  
    } 
    
    public static <T> Converter<String, ?>  getConverter(Class<?> clz){
		return null;
    	
    }
      
}  