package com.vnext.w13reflect;

import java.lang.reflect.Method;

public abstract class ExcelDTO {  
    public  void putValue(String name,Object value){  
        Class<? extends ExcelDTO> c = this.getClass();  
        Class<? extends Object> v = value.getClass();  
        try{  
            Method m = c.getMethod("set"+name, new Class[]{v});  
            m.invoke(this, new Object[]{value});  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
    public Object outValue(String name){  
        Class<? extends ExcelDTO> c = this.getClass();  
        Object o =null;  
        try{  
            Method m = c.getMethod("get"+name, new Class[]{});  
            o = m.invoke(this, new Object[]{});  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return o;  
    }  
}  