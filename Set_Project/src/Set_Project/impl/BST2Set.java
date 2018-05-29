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
public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;
    
    public BST2Set(){
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T value) {
        if(root == null){
            root = new OnOffTreeNode(value);
            size++;
        }
        else if(addHelper(value, root))size++;
    }
    private boolean addHelper(T value, OnOffTreeNode<T> cur){
         if(value.equals(cur.getValue())){
             boolean res = !cur.isActive();
             cur.switchOn();
             return res;
         }
         else if(value.compareTo(cur.getValue()) <= 0){
            if(cur.getLeft() == null){
                cur.setLeft(new OnOffTreeNode(value));
                return true;
            }
            else return addHelper(value, cur.getLeft());
         }
         else{
            if(cur.getRight() == null){
                cur.setRight(new OnOffTreeNode(value));
                return true;
            }
            else return addHelper(value, cur.getRight());
        }
    }
    private boolean containsHelper(T value, OnOffTreeNode<T> cur){
        if(cur == null)return false;
        else if(value.equals(cur.getValue()))return cur.isActive();
        else if(value.compareTo(cur.getValue()) <= 0)return containsHelper(value, cur.getLeft());
        else  return containsHelper(value, cur.getRight());
    }
    
    @Override
    public boolean contains(T value) {
        return containsHelper(value, root);
    }
    
    @Override
    public boolean remove(T value) {
        OnOffTreeNode<T> cur = root;
        
        while(cur != null && !value.equals(cur.getValue())){
            if(value.compareTo(cur.getValue()) <= 0)cur = cur.getLeft();
            else cur = cur.getRight();
        }
        if(cur == null || !cur.isActive())return false;
        cur.switchOff();
        size--;
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0)throw new Exception("The Set is Empty!");
        size--;
        OnOffTreeNode<T> res = removeActive(root);
        res.switchOff();
        return res.getValue();
    }
    
    private OnOffTreeNode<T> removeActive(OnOffTreeNode<T> cur){
        if(cur == null)return null;
        else if(cur.isActive())return cur;
        else{
            OnOffTreeNode<T> res = removeActive(cur.getLeft());
            if(res == null)return removeActive(cur.getRight());
            else return res;
        }
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
        return "[ " + findString(root)+ "]";
    }
    
    private String findString(OnOffTreeNode<T> nd){
        if(nd == null)return "";
        String res = findString(nd.getLeft());
        if(nd.isActive())res += nd.toString() + " ";
        res += findString(nd.getRight());
        return res;
    }

    
}
