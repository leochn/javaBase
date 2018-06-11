package com.vnext.w18socket.bio03;

/**
 * @author leo
 * @version 2018/6/10 18:36
 * @since 1.0.0
 */
public class GetDataServiceImpl implements GetDataService{

    @Override
    public String getData(String input) {

        return "ServerSocket :" + input;
    }
}