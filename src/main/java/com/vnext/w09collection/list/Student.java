package com.vnext.w09collection.list;

/**
 * @author leo
 * @since 2018-03-15 16:05:25
 */
public class Student {  
    private String name;  
    private int money;  
    
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getMoney() {  
        return money;  
    }  
    public void setMoney(int money) {  
        this.money = money;  
    }  
    @Override  
    public int hashCode() {  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + money;  
        result = prime * result + ((name == null) ? 0 : name.hashCode());  
        return result;  
    }  
    @Override  
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Student other = (Student) obj;  
        //将money属性注释,则对象的equals()方法会忽略money属性的比较  
//      if (money != other.money)  
//          return false;  
        if (name == null) {  
            if (other.name != null)  
                return false;  
        } else if (!name.equals(other.name))  
            return false;  
        return true;  
    }  
    @Override  
    public String toString() {  
        return "Student [name=" + name + ", money=" + money + "]";  
    }  
      
}  
