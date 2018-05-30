package com.frame.converter;

/**
 * @author shuijun liu
 * @时间：2017年8月24日 下午5:47:58  
 * @版本：
 * @注释：    
 * @param <E> 转换体
 * @param <T>转换目标
 */
public interface Converter <E,T>{
	public  T convert(E e) throws Exception;
}
