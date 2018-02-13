package com.vnext.w01datatype;

import org.junit.Test;

/**
 * String类
 * @author leo
 * @since 2018/2/12 17:25
 */
public class TestString01 {
    /**
     1）String类是final类，也即意味着String类不能被继承，并且它的成员方法都默认为final方法。在Java中，被final修饰的类是不允许被继承的，并且该类中的成员方法都默认为final方法。
     2）上面列举出了String类中所有的成员属性，从上面可以看出String类其实是通过char数组来保存字符串的。
     3）String对象一旦被创建就是固定不变的了，对String对象的任何改变都不影响到原对象，相关的任何change操作都会生成新的对象
     字符串常量：
        每当我们创建字符串常量时，JVM会首先检查字符串常量池，如果该字符串已经存在常量池中，
        那么就直接返回常量池中的实例引用。如果字符串不存在常量池中，就会实例化该字符串并且将其放到常量池中。
        由于String字符串的不可变性我们可以十分肯定常量池中一定不存在两个相同的字符串。
     */

    /**
     * 采用字面值的方式赋值
     */
    @Test
    public void test01(){
        String str1="aaa";
        String str2="aaa";
        System.out.println(str1==str2);//true 可以看出str1跟str2是指向同一个对象
        /**
         分析：
            当执行String str1="aaa"时，JVM首先会去字符串池中查找是否存在"aaa"这个对象，如果不存在，
            则在字符串池中创建"aaa"这个对象，然后将池中"aaa"这个对象的引用地址返回给字符串常量str1，
            这样str1会指向池中"aaa"这个字符串对象；如果存在，则不创建任何对象，直接将池中"aaa"这个对象的地址返回，赋给字符串常量。
            当创建字符串对象str2时，字符串池中已经存在"aaa"这个对象，直接把对象"aaa"的引用地址返回给str2，这样str2指向了池中"aaa"这个对象，
            也就是说str1和str2指向了同一个对象，因此语句System.out.println(str1 == str2)输出：true。
         */
    }

    /**
     * 采用new关键字新建一个字符串对象
     */
    @Test
    public void test02(){
        String str3=new String("aaa");
        String str4=new String("aaa");
        System.out.println(str3==str4);//false 可以看出用new的方式是生成不同的对象
        /**
         分析：
            采用new关键字新建一个字符串对象时，JVM首先在字符串池中查找有没有"aaa"这个字符串对象，
            如果有，则不在池中再去创建"aaa"这个对象了，直接在堆中创建一个"aaa"字符串对象，
            然后将堆中的这个"aaa"对象的地址返回赋给引用str3，这样，str3就指向了堆中创建的这个"aaa"字符串对象；
            如果没有，则首先在字符串池中创建一个"aaa"字符串对象，然后再在堆中创建一个"aaa"字符串对象，然后将堆中这个"aaa"字符串对象的地址返回赋给str3引用，
            这样，str3指向了堆中创建的这个"aaa"字符串对象。当执行String str4=new String("aaa")时，
            因为采用new关键字创建对象时，每次new出来的都是一个新的对象，也即是说引用str3和str4指向的是两个不同的对象，
            因此语句System.out.println(str3 == str4)输出：false。
         */
    }

    /**
     * 编译期确定
     */
    @Test
    public void test03(){
        String s0="helloworld";
        String s1="helloworld";
        String s2="hello"+"world";
        System.out.println(s0==s1); //true 可以看出s0跟s1是指向同一个对象
        System.out.println(s0==s2); //true 可以看出s0跟s2是指向同一个对象/
        /**
         分析：
            因为例子中的s0和s1中的"helloworld”都是字符串常量，它们在编译期就被确定了，所以s0==s1为true；
            而"hello”和"world”也都是字符串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，
            所以s2也同样在编译期就被解析为一个字符串常量，所以s2也是常量池中"helloworld”的一个引用。所以我们得出s0==s1==s2。
         */
    }

    /**
     * 编译期无法确定
     */
    @Test
    public void test04(){
        String s0 = "helloworld";
        String s1 = new String("helloworld");
        String s2 = "hello" + new String("world");
        System.out.println(s0 == s1); //false
        System.out.println(s0 == s2); //false
        System.out.println(s1 == s2); //false
        /**
         * 分析：
            用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String() 创建的字符串不放入常量池中，它们有自己的地址空间。
            s0还是常量池中"helloworld”的引用，s1因为无法在编译期确定，所以是运行时创建的新对象"helloworld”的引用，
            s2因为有后半部分new String(”world”)所以也无法在编译期确定，所以也是一个新创建对象"helloworld”的引用。
         */
    }

    /**
     * 继续-编译期无法确定
     */
    @Test
    public void test05(){
        String str1 = "abc";
        String str2 = "def";
        String str3 = str1 + str2;
        System.out.println(str3 == "abcdef"); //false
        /**
         分析：
            因为str3指向堆中的"abcdef"对象，而"abcdef"是字符串池中的对象，所以结果为false。
            JVM对String str="abc"对象放在常量池中是在编译时做的，而String str3=str1+str2是在运行时刻才能知道的。
            new对象也是在运行时才做的。而这段代码总共创建了5个对象，字符串池中两个、堆中三个。
            +运算符会在堆中建立来两个String对象，这两个对象的值分别是"abc"和"def"，
            也就是说从字符串池中复制这两个值，然后在堆中创建两个对象，然后再建立对象str3,然后将"abcdef"的堆地址赋给str3。
         步骤：
            1)栈中开辟一块中间存放引用str1，str1指向池中String常量"abc"。
            2)栈中开辟一块中间存放引用str2，str2指向池中String常量"def"。
            3)栈中开辟一块中间存放引用str3。
            4)str1 + str2通过StringBuilder的最后一步toString()方法还原一个新的String对象"abcdef"，因此堆中开辟一块空间存放此对象。
            5)引用str3指向堆中(str1 + str2)所还原的新String对象。
            6)str3指向的对象在堆中，而常量"abcdef"在池中，输出为false。
         */
    }

    /**
     * 编译期优化
     */
    @Test
    public void test06(){
        String s0 = "a1";
        String s1 = "a" + 1;
        System.out.println((s0 == s1)); //true
        String s2 = "atrue";
        String s3= "a" + "true";
        System.out.println((s2 == s3)); //true
        String s4 = "a3.4";
        String s5 = "a" + 3.4;
        System.out.println((s4 == s5)); //true
        /**
         分析：
            在程序编译期，JVM就将常量字符串的"+"连接优化为连接后的值，拿"a" + 1来说，经编译器优化后在class中就已经是a1。
            在编译期其字符串常量的值就确定下来，故上面程序最终的结果都为true
         */
    }

    /**
     * 编译期无法确定
     */
    @Test
    public void test07(){
        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        System.out.println((s0 == s2)); //false
        /**
         分析：
            JVM对于字符串引用，由于在字符串的"+"连接中，有字符串引用存在，
            而引用的值在程序编译期是无法确定的，即"a" + s1无法被编译器优化，
            只有在程序运行期来动态分配并将连接后的新地址赋给s2。所以上面程序的结果也就为false。
         */
    }

    /**
     * 比较字符串常量的“+”和字符串引用的“+”的区别
     */
    @Test
    public void test08(){
        String test="javalanguagespecification";
        String str="java";
        String str1="language";
        String str2="specification";
        System.out.println(test == "java" + "language" + "specification"); // true
        System.out.println(test == str + str1 + str2); //false
        /**
         分析：
            为什么出现上面的结果呢？这是因为，字符串字面量拼接操作是在Java编译器编译期间就执行了，
            也就是说编译器编译时，直接把"java"、"language"和"specification"这三个字面量进行"+"操作得到一个"javalanguagespecification" 常量，
            并且直接将这个常量放入字符串池中，这样做实际上是一种优化，将3个字面量合成一个，避免了创建多余的字符串对象。
            而字符串引用的"+"运算是在Java运行期间执行的，即str + str2 + str3在程序执行期间才会进行计算，它会在堆内存中重新创建一个拼接后的字符串对象。
         总结来说就是：
            字面量"+"拼接是在编译期间进行的，拼接后的字符串存放在字符串池中；
            而字符串引用的"+"拼接运算实在运行时进行的，新创建的字符串存放在堆中。

         对于直接相加字符串，效率很高，因为在编译器便确定了它的值，也就是说形如"I"+"love"+"java"; 的字符串相加，在编译期间便被优化成了"Ilovejava"。
         对于间接相加（即包含字符串引用），形如s1+s2+s3; 效率要比直接相加低，因为在编译器不会对引用变量进行优化。
         */
    }
    /**
     * 编译期确定
     */
    @Test
    public void test09(){
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println((s0 == s2)); //true
        /**
         分析：
            和例子7中唯一不同的是s1字符串加了final修饰，
            对于final修饰的变量,它在编译时被解析为常量值的一个本地拷贝,存储到自己的常量池中或嵌入到它的字节码流中。
            所以此时的"a" + s1和"a" + "b"效果是一样的。故上面程序的结果为true。
         */
    }

    /**
     * 编译期无法确定
     */
    @Test
    public void test10() {
        String s0 = "ab";
        final String s1 = getS1();
        String s2 = "a" + s1;
        System.out.println((s0 == s2)); //false
        /**
         分析：这里面虽然将s1用final修饰了，但是由于其赋值是通过方法调用返回的，那么它的值只能在运行期间确定，
         因此s0和s2指向的不是同一个对象，故上面程序的结果为false。
         */

    }
    private String getS1() {
        return "b";
    }

    /**
     * 关于String.intern()
     */
    @Test
    public void test11(){
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");
        System.out.println( s0 == s1 ); //false
        s1.intern();      //虽然执行了s1.intern(),但它的返回值没有赋给s1
        s2 = s2.intern(); //把常量池中"kvill"的引用赋给s2
        System.out.println( s0 == s1); //flase
        System.out.println( s0 == s1.intern() ); //true//说明s1.intern()返回的是常量池中"kvill"的引用
        System.out.println( s0 == s2 ); //true
        /**
         * String的intern()方法就是扩充常量池的一个方法；
         * 当一个String实例str调用intern()方法时，java查找常量池中是否有相同unicode的字符串常量，如果有，则返回其引用，
         * 如果没有，则在常量池中增加一个unicode等于str的字符串并返回它的引用。
         */
    }

    /**
     * 关于String.intern()
     */
    @Test
    public void test12(){
        String bb = new String(new char[]{'a'});
        bb.intern();
        String cc = new String("a");
        cc.intern();
        String aa = "a";
        System.out.println(aa == bb); //false
        System.out.println(aa == cc); //false

        String str2 = new String("str") + new String("01");
        String str3 = new String("str") + new String("01");
        str2.intern();
        str3.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);//true   ??
        System.out.println(str3 == str1);//false  ??
    }

    /**
     * 关于equals和==
     */
    @Test
    public void test13(){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println( s1 == s2); //true,表示s1和s2指向同一对象，它们都指向常量池中的"hello"对象
        System.out.println( s1 == s3); //flase,表示s1和s3的地址不同，即它们分别指向的是不同的对象,s1指向常量池中的地址，s3指向堆中的地址
        System.out.println( s1.equals(s3)); //true,表示s1和s3所指向对象的内容相同
    }


    /**
     * String:代表不可变的字符序列。底层使用char[]存放。
     * String 是final的。
     */
    @Test
    public void test010(){
        String str1 = "JavaEE";
        String str2 = "JavaEE";
        String str3 = new String("JavaEE");
        String str4 = "JavaEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;
        str5 = str5 + "Handoop";
        String str7 = str6.intern();
        String str8 = "JavaEEAndroid";
        String str9 = new String(new char[]{'k'});
        str9.intern();
        String str10 = "k";

        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true

        System.out.println(str4 == str6);//false
        System.out.println(str4.equals(str6));//true
        System.out.println(str7 == str4);//true
        System.out.println(str4 == str8);//true
        System.out.println(str9 == str10);// true

        Person p1 = new Person("AA");
        Person p2 = new Person("AA");
        System.out.println("^_^"+ (p1.name == p2.name));//true
    }

}

class Person{
    String name;
    Person(String name){
        this.name = name;
    }
}

/**
 总结：
 1.String类初始化后是不可变的(immutable)
    String使用private final char value[]来实现字符串的存储，也就是说String对象创建之后，
    就不能再修改此对象中存储的字符串内容，就是因为如此，才说String类型是不可变的(immutable)。

 2.创建字符串的方式
    创建字符串的方式归纳起来有两类：
        （1）使用""引号创建字符串;
        （2）使用new关键字创建字符串。
    结合上面例子，总结如下:
        （1）单独使用""引号创建的字符串都是常量,编译期就已经确定存储到String Pool中；
        （2）使用new String("")创建的对象会存储到heap中,是运行期新创建的；
                new创建字符串时首先查看池中是否有相同值的字符串，如果有，则拷贝一份到堆中，然后返回堆中的地址；
                如果池中没有，则在堆中创建一份，然后返回堆中的地址（注意，此时不需要从堆中复制到池中，
                否则，将使得堆中的字符串永远是池中的子集，导致浪费池的空间）！
        （3）使用只包含常量的字符串连接符如"aa" + "aa"创建的也是常量,编译期就能确定,已经确定存储到String Pool中；
        （4）使用包含变量的字符串连接符如"aa" + s1创建的对象是运行期才创建的,存储在heap中；

 3.使用String不一定创建对象
    在执行到双引号包含字符串的语句时，如String a = "123"，JVM会先到常量池里查找，如果有的话返回常量池里的这个实例的引用，
    否则的话创建一个新实例并置入常量池里。
    所以，当我们在使用诸如String str = "abc"；的格式定义对象时，总是想当然地认为，创建了String类的对象str。
    担心陷阱！对象可能并没有被创建！而可能只是指向一个先前已经创建的对象。只有通过new()方法才能保证每次都创建一个新的对象。

 4.关于equals和==
 （1）对于==，如果作用于基本数据类型的变量（byte,short,char,int,long,float,double,boolean ），则直接比较其存储的"值"是否相等；
      如果作用于引用类型的变量（String），则比较的是所指向的对象的地址（即是否指向同一个对象）。
 （2）equals方法是基类Object中的方法，因此对于所有的继承于Object的类都会有该方法。
      在Object类中，equals方法是用来比较两个对象的引用是否相等，即是否指向同一个对象。
 （3）对于equals方法，注意：equals方法不能作用于基本数据类型的变量。如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
      而String类对equals方法进行了重写，用来比较指向的字符串对象所存储的字符串是否相等。
      其他的一些类诸如Double，Date，Integer等，都对equals方法进行了重写用来比较指向的对象所存储的内容是否相等。























 */
