package com.vnext.w09collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author leo
 * @since 2018-02-08 18:13:00
 */
public class TestList02 {
	
	@Test
	public void test01() {
		List<User> userList = new ArrayList<User>();
        User user1 = new User("张三", "001");
        userList.add(user1);
        User user2 = new User("李四", "001");
        userList.add(user2);
        User user3 = new User("王五", "002");
        userList.add(user3);
        for (User u : userList) {
            System.out.println(u.getName() + ";"+ u.getUserId());
        }
        List<User> userListNoDupAndSort = removeDuplicateUser(userList);
        System.out.println("去重后=======>");
        for (User u : userListNoDupAndSort) {
            System.out.println(u.getName() + ";"+ u.getUserId());
        }
	}
	
	private ArrayList<User> removeDuplicateUser(List<User> users) {
        Set<User> set = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //字符串,则按照asicc码升序排列
                return o1.getUserId().compareTo(o2.getUserId());
            }
        });
        set.addAll(users);
        return new ArrayList<User>(set);
    }

}
