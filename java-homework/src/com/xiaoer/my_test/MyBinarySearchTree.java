package com.xiaoer.my_test;

public class MyBinarySearchTree {
    Node root;
    int size;

    public void add(int element){
        //首次添加
        if(root == null){
            root = new Node(element, null);
            size++;
            return;
        }
        //非首次添加
        //查找位置
        Node parent = root;
        Node node = root;
        int cmp = 0;
        while(node != null){
            if(element > node.elem){
                node = node.right;
                cmp = 1;
            }else if(element < node.elem){
                node = node.left;
                cmp = -1;
            }else{
                return;
            }
        }
        //添加元素
        Node newNode = new Node(element, parent);
        if(cmp == 1){
            parent.right = newNode;
        }else if(cmp == -1){
            parent.left = newNode;
        }

    }

    private class Node{
        int elem;
        Node parent;
        Node left;
        Node right;
        public Node(int elem, Node parent){
            this.elem = elem;
            this.parent = parent;
        }
    }
}
