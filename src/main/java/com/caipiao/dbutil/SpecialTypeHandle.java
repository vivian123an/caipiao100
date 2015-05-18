package com.caipiao.dbutil;

public interface SpecialTypeHandle<T extends Object> {
	
	public Class<T> getClassSimpleName();  
    
    public T getResultObject(Class<?> eClass,Object value);  
}
