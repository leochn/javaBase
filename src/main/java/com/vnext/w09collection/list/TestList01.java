package com.vnext.w09collection.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leo
 * @since 2018-03-15 16:05:10
 */
public class TestList01 {
	
	public static void main(String[] args) {
		Student s1 = new Student();  
	    s1.setName("peter");  
	    s1.setMoney(10);  
	    Student s2 = new Student();  
	    s2.setName("peter");  
	    s2.setMoney(20);  
	    Student s3 = new Student();  
	    s3.setName("jack");  
	    s3.setMoney(5);  
	    Student s4 = new Student();  
	    s4.setName("jack");  
	    s4.setMoney(15);  
	    List<Student> list = new ArrayList<Student>();  
	    list.add(s1);  
	    list.add(s2);  
	    list.add(s3);  
	    list.add(s4); 
	    
	    
	    for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {  
            for (int j = list.size() - 1 ; j > i; j --) {  
                Student stu = list.get(i);  
                Student otherStu = list.get(j);  
                if(stu.equals(otherStu)) {  
                    int money = stu.getMoney();  
                    int otherMoney = otherStu.getMoney();  
                    int totalMoney = money + otherMoney;  
                    stu.setMoney(totalMoney);  
                    list.remove(j);    
                }  
            }  
        }
	    
	    for (Student student : list) {  
            System.out.println(student.toString());  
        }  
	    
	    System.out.println("------------------------");
	    
	    Map<String, Student> map = new HashMap<String, Student>();    
        for (Student student : list) {  
            String key = student.getName();  
            if(map.containsKey(key)) {  
                Student stu = map.get(key);  
                int preMoney = stu.getMoney();  
                int total = preMoney + student.getMoney();  
                student.setMoney(total);  
            }   
            map.put(key, student);  
        }  
          
        list.clear();  
        list.addAll(map.values());  
          
        for (Student student : list) {  
            System.out.println(student.toString());  
        }  
	}
	
	
	
	
	

}
