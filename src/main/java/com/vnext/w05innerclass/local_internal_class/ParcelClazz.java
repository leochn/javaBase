package com.vnext.w05innerclass.local_internal_class;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 19:27:05
 */
public class ParcelClazz {
    private int num = 10;

    public void method(){
        int num2 = 20;
        final int num3 = 30;

        // 局部内部类（定义在方法内）
        class InnerClazz{
            private void show() {
                System.out.println("inner-num = " + num);  //10
                System.out.println("inner-num2 = " + num2);//20
                System.out.println("inner-num3 = " + num3);//30
            }
        }
        System.out.println("num2 = " + num2);//20
        InnerClazz inner = new InnerClazz();
        inner.show();
    }

    public void internalTracking(boolean flag){
        if (flag){
            // 局部内部类, 定义在作用域内
            class TrackingSlip{
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("chenssy");
            String string = ts.getSlip();
            System.out.println( "hello,TrackingSlip.." + string);
        }
    }

    public void track(){
        internalTracking(true);
    }
}