///**
// *
// */
//package com.vnext.mockito;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//
//*
// * @author leo
// * @since 2018-02-06 13:51:45
//public class TestUserService {
//
//    private UserService _userService = new UserService();
//
//    @Test
//    public void testIsAdult4UserExist() {
//        long userId = 123;
//        User user = new User(userId, "张三", 19);
//
//        // 大于18岁的测试用例
//        UserDao daoMock = mock(UserDao.class);
//        when(daoMock.queryById(userId)).thenReturn(user); // 设置行为和对应的返回值
//        _userService.setUserDao(daoMock); // 设置mock
//        assertTrue(_userService.isAdult(userId)); // 校验结果
//
//        // 等于18岁的测试用例
//        User user2 = new User(userId, "李四", 18);
//        when(daoMock.queryById(userId)).thenReturn(user2);
//        _userService.setUserDao(daoMock);
//        assertTrue(_userService.isAdult(userId));
//
//        // 小于18岁的测试用例
//        User user3 = new User(userId, "王五", 17);
//        when(daoMock.queryById(userId)).thenReturn(user3);
//        _userService.setUserDao(daoMock);
//        assertFalse(_userService.isAdult(userId));
//    }
//
//    @Test
//    public void testIsAdult4UserNotExist() {
//        // 用户不存在的测试用例
//        long userId = 123;
//        UserDao daoMock = mock(UserDao.class);
//        when(daoMock.queryById(userId)).thenReturn(null); // 设置行为和对应的返回值
//        _userService.setUserDao(daoMock); // 设置mock
//        assertFalse(_userService.isAdult(userId)); // 校验结果
//    }
//
//}
