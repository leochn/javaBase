package com.vnext.w14multi.m04future;

/**
 * realData：真实数据
 * @author leo
 * @version 2018/2/10 20:32
 * @since 1.0.0
 */
public class RealData implements Data {
    private String result;

    public RealData(String request) {
        System.out.println("根据 " + request + " 计算投资金额,开始计算,要花比较长的时间...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕,获取到了真实的结果，花了5秒钟..");
        result = "我们投资需要花 500 万";
    }

    @Override
    public String getRequest() {
        return result;
    }
}

