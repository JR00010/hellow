package com.frame.converter;

/**
 * @author shuijun liu
 * @ʱ�䣺2017��8��24�� ����5:47:58  
 * @�汾��
 * @ע�ͣ�    
 * @param <E> ת����
 * @param <T>ת��Ŀ��
 */
public interface Converter <E,T>{
	public  T convert(E e) throws Exception;
}
