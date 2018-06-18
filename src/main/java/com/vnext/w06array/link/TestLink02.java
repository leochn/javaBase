package com.vnext.w06array.link;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-16 10:39:11
 */
public class TestLink02 {

    public static void main(String[] args) {
        Link02 link = new Link02();
        System.out.println("link.isEmpty()=" + link.isEmpty());
        link.add("Hello");
        link.add("World");
        link.add("WWW");
        link.add("JAVA");
        link.add(".NET");
        link.add("PHP");
        link.add(null);//link.print();
        System.out.println("link.size()=" + link.size());
        System.out.println("link.isEmpty()=" + link.isEmpty());
        System.out.println(link.contains("JAVA1"));
        System.out.println(link.get(1));
        System.out.println(link.get(10));
        System.out.println(link.set(10,"WHAT??"));
        System.out.println(link.get(10));
    }

}

class Link02 {
    private class Node02 {
        private String data;
        private Node02 next;

        public Node02(String data) {
            this.data = data;
        }

        public void addNode(Node02 newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                // 当前节点的下一个节点继续保存
                this.next.addNode(newNode);
            }

        }

        // 第一次调用(Link)：  this = Link.root
        // 第二次调用(Nodeo1)：this = Link.root.next
        // 第三次调用(Nodeo1)：this = Link.root.next.next
        public boolean containsNode(String data) {
            if (data.equals(this.data)) { // 当前节点数据为要查询的数据
                return true; // 后面不要查询了
            } else { // 当前节点数据不满足查询要求
                if (this.next != null) { // 有后续节点
                    return this.next.containsNode(data);
                } else { // 没有后续节点了
                    return false;
                }
            }

        }

        // 内部类和外部类之间可以方便的进行私有属性的互相访问
        public String getNode(int index) {
            // 使用当前的foot内容与要查询的索引进行比较
            // 随后将foot的内容自增，目的是为了下次查询方便
            // 内部类如何访问外部类的属性：Link02.this.foot
            if (Link02.this.foot++ == index) { // 为要查询的索引
                return this.data; // 放回当前节点数据
            } else {
                // 现在应该继续向后查询
                return this.next.getNode(index);
            }

        }

        public boolean setNode(int index, String data) {
            if (Link02.this.foot ++ == index){
                this.data = data; // 进行内容修改
                return true;
            }else {
                return this.next.setNode(index,data);
            }

        }
    }

    //-----------以上为内部类------------
    private Node02 root; // 需要根节点

    // 取得保存元素个数
    // 既然每一个链表对象都只有一个root根元素，那么每一个链表就都有自己的长度，可以直接在Link类中设置一个count属性，随后每一次数据添加完成之后，可以进行个数的自增。
    private int count = 0;   // 保存元素的个数

    private int foot = 0; // 表示每一个Node元素的编号

    // 1. 向链表中添加新元素
    // 如果要进行数据的增加，则应该有Link02类负责节点对象的产生，并且有Link类维护根节点，所有的节点的关系匹配交给Node02类负责处理
    public void add(String data) {
        Node02 newNode = new Node02(data);
        if (data == null) return;
        if (this.root == null) {
            // 还没有根节点
            this.root = newNode; // 保存根节点
        } else {
            // 跟节点已经存在了
            // 随后增加的元素该交由节点来处理
            // 从root节点之后找到合适的位置
            this.root.addNode(newNode);
        }
        this.count++; // 每次完成后，元素个数加1
    }

    // 2.返回元素的个数
    public int size() {
        return this.count;
    }

    // 3.判断是否为空链表
    // 两种方式：root是否为null; count的个数
    public boolean isEmpty() {
        return this.count == 0;
    }

    // 4.数据类型查询
    // 在链表中一定会保存有多个数据，那么基本的判断数据是否存在的方式：
    //    以String为列，循环链表中的内容并且与要查询的数据进行匹配(equals()),如果找到了则返回true，否则返回false
    public boolean contains(String data) {
        // 现在没有要查询的数据，根节点也不保存数据
        if (data == null || this.root == null) return false;
        return this.root.containsNode(data);
    }

    // 5.根据索引获取数据
    public String get(int index) {
        if (index > this.count) return null; // 超过了查询范围没有数据
        this.foot = 0; // 表示从前后查询
        return this.root.getNode(index); // 将查询过程交给node处理
    }

    // 6.修改指定索引内容
    public boolean set(int index, String data) {
        if (index > this.count) return false;
        this.foot = 0; // 重新设置foot属性的内容，作为索引出现
        return this.root.setNode(index, data);
    }


}