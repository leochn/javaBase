package com.vnext.w18socket.nio01;

import java.nio.IntBuffer;

/**
 * @author leo
 * @version 2018/3/3 17:45
 * @since 1.0.0
 */
public class TestBuffer {

    public static void main(String[] args) {

        // 1 基本操作

        //创建指定长度的缓冲区
        IntBuffer buf = IntBuffer.allocate(10);
        buf.put(13);// position位置：0 - > 1
        buf.put(21);// position位置：1 - > 2
        buf.put(35);// position位置：2 - > 3

        //把位置复位为0，也就是position位置：3 - > 0
        buf.flip();   // 注释该语句测试一下

        System.out.println("使用flip复位：" + buf);
        System.out.println("容量为: " + buf.capacity());    //容量一旦初始化后不允许改变（warp方法包裹数组除外）
        System.out.println("限制为: " + buf.limit());        //由于只装载了三个元素,所以可读取或者操作的元素为3 则limit=3

        System.out.println("获取下标为1的元素：" + buf.get(1));
        System.out.println("get(index)方法，position位置不改变：" + buf);
        buf.put(1, 4);
        System.out.println("put(index, change)方法，position位置不变：" + buf);

        for (int i = 0; i < buf.limit(); i++) {
            //调用get方法会使其缓冲区位置（position）向后递增一位
            System.out.println(buf.get());
        }
        System.out.println("buf对象遍历之后为: " + buf);
        System.out.println("---------------------------------------");

        // 2 wrap方法使用
        //  wrap方法会包裹一个数组: 一般这种用法不会先初始化缓存对象的长度，因为没有意义，最后还会被wrap所包裹的数组覆盖掉。
        //  并且wrap方法修改缓冲区对象的时候，数组本身也会跟着发生变化。
        int[] arr = new int[]{1, 2, 5};
        IntBuffer buf1 = IntBuffer.wrap(arr);
        System.out.println(buf1);

        IntBuffer buf2 = IntBuffer.wrap(arr, 0, 2);
        //这样使用表示容量为数组arr的长度，但是可操作的元素只有实际进入缓存区的元素长度
        System.out.println(buf2);
        System.out.println("---------------------------------------");

        // 3 其他方法
        IntBuffer buf3 = IntBuffer.allocate(10);
        int[] arr3 = new int[]{1, 2, 5};
        buf3.put(arr3);
        System.out.println(buf3);

        //一种复制方法
        IntBuffer buf4 = buf3.duplicate();
        System.out.println(buf4);

        //设置buf3的位置属性
        buf3.position(1); // 可以手动设置positon的位置
        //buf3.flip();
        System.out.println(buf3);

        System.out.println("可读数据为：" + buf3.remaining());

        //将缓冲区数据放入arr4数组中去
        int[] arr4 = new int[buf3.remaining()];
        for (int i : arr4) {
            System.out.print(Integer.toString(i) + ",");
        }
        System.out.println("======");

        IntBuffer intBuffer = buf3.get(arr4);
        System.out.println(intBuffer);

    }
}
