package com.vnext.w06array.link;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 09:35:22
 */
public class TestLink01 {

    public static void main(String[] args) {
        // 准备数据
        Node01 root = new Node01("火车头");
        Node01 n1 = new Node01("车厢A");
        Node01 n2 = new Node01("车厢B");
        root.setNext(n1);
        n1.setNext(n2);

        // 取数据
        Node01 currentNode = root;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println("----------");
        printNode(root);

        System.out.println("========================");
        Link link = new Link();
        link.add("Hello");
        link.add("World");
        link.add("WWW");
        link.add("JAVA");
        link.print();
    }

    /**
     * 递归打印
     *
     * @param current 当前节点
     */
    public static void printNode(Node01 current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getData());
        printNode(current.getNext());
    }


}

// 每个链表实际上就是有多个节点所组成的
class Node01 {
    private String data; // 要保存的数据
    private Node01 next; // 要保存的下一个节点

    public Node01(String data) {
        this.data = data;
    }

    public Node01 getNext() {
        return next;
    }

    public void setNext(Node01 next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // 实现节点的添加
    // 第一次调用(Link)：  this = Link.root
    // 第二次调用(Nodeo1)：this = Link.root.next
    // 第三次调用(Nodeo1)：this = Link.root.next.next
    public void addNode(Node01 newNode) {
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
    public void pringNode() {
        System.out.println(this.data); // 输出当前节点数据
        if (this.next != null) {
            // 现在还有下一个节点
            this.next.pringNode(); // 输出下一个节点
        }

    }
}

// 负责数据的设置和输出
class Link {

    private Node01 root;

    // 增加数据
    public void add(String data) {
        Node01 newNode = new Node01(data);
        if (this.root == null) {
            // 还没有根节点
            this.root = newNode; // 保存根节点
        } else {
            // 跟节点已经存在了
            // 随后增加的元素该交由节点来处理
            // 从root节点之后找到合适的位置
            this.root.addNode(newNode);
        }
    }

    // 输出数据
    public void print() {
        if (this.root != null){
            this.root.pringNode();
        }
    }
}