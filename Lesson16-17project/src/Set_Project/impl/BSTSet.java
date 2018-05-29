package Set_Project.impl;

import Set_Project.adt.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T value) {
        TreeNode<T> nd = new TreeNode(value);
        if(root == null)root = nd;
        else{
            TreeNode<T> res = nodeFinder(value, root);
            if(res == null)return;
            if(value.compareTo(res.getValue()) <= 0)res.setLeft(nd);
            else res.setRight(nd);
        }
        size++;
    }
    
    private TreeNode<T> nodeFinder(T value, TreeNode<T> cur){
        if(value.equals(cur.getValue()))return null;
        else if(value.compareTo(cur.getValue()) <= 0){
            if(cur.getLeft() == null)return cur;
            else return nodeFinder(value, cur.getLeft());
        }
        else{
            if(cur.getRight() == null)return cur;
            else return nodeFinder(value, cur.getRight());
        }
    }
    
    @Override
    public boolean contains(T value) {
        return (nodeFinder(value, root) == null);
    }
    
    private void removeSimpleNode(TreeNode<T> cur, TreeNode<T> par, boolean isleft){
        if(par == null){
            if(cur.getLeft() == null && cur.getRight() == null) root = null;
            else if(cur.getLeft() == null && cur.getRight() != null)root = cur.getRight();
            else root = cur.getLeft();
        }
        else if(cur.getLeft() == null && cur.getRight() == null){
            if(isleft)par.setLeft(null);
            else par.setRight(null);
        }
        else if(cur.getLeft() == null && cur.getRight() != null){
            if(isleft)par.setLeft(cur.getRight());
            else par.setRight(cur.getRight());
        }
        else {
            if(isleft)par.setLeft(cur.getLeft());
            else par.setRight(cur.getLeft());
        }
    }
    
    private T removeMin(TreeNode<T> cur, TreeNode<T> par, boolean isleft){
        if(cur.getLeft() != null)return removeMin(cur.getLeft(), cur, true);
        else{
            T res = cur.getValue();
            removeSimpleNode(cur, par, isleft);
            return res;
        }
    }
    
    @Override
    public boolean remove(T value) {
        TreeNode<T> cur = root, par = null;
        boolean isleft = false;
        
        while(cur != null && !value.equals(cur.getValue())){
            par = cur;
            if(value.compareTo(cur.getValue()) <= 0){
                cur = cur.getLeft();
                isleft = true;
            }
            else {
                cur = cur.getRight();
                isleft = false;
            }
        }
        if(cur == null)return false;
        size --;
        
        if(cur.getRight() == null || cur.getLeft() == null)removeSimpleNode(cur, par, isleft);
        else cur.setValue(removeMin(cur.getRight(), cur, false));
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0)throw new Exception("The Set is Empty!");
        size--;
        return removeMin(root, null, false);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        return findString(root);
    }
    
    private String findString(TreeNode<T> nd){
        if(nd == null)return "";
        return findString(nd.getLeft()) + nd.toString() + " " + findString(nd.getRight());
    }

    
}
