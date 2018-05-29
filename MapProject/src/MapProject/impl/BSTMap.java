/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapProject.impl;

import MapProject.adt.Map;

/**
 *
 * @author Nurtas
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable,V> implements Map<K, V>{

    private TreeNode<KeyValuePair<K,V>> root;
    private int size;
	
    public BSTMap() {
	root = null;
	size = 0; 
   }
	
    @Override
    public void define(K key, V value) {
	if(root == null){
            root = new TreeNode(new KeyValuePair(key, value));
            size++;
        }
        else defineHelper(root, null, key, value);
    }
    
    private void defineHelper(TreeNode<KeyValuePair<K,V>> cur, TreeNode<KeyValuePair<K,V>> par, K key, V value){
        if(cur == null){
            size++;
            if(par.getValue().getKey().compareTo(key) >= 0)par.setLeft(new TreeNode(new KeyValuePair(key, value)));
            else par.setRight(new TreeNode(new KeyValuePair(key, value)));
        }
        else if(cur.getValue().getKey().equals(key))cur.setValue(new KeyValuePair(key, value));
        else if(cur.getValue().getKey().compareTo(key) >= 0)defineHelper(cur.getLeft(), cur, key, value);
        else defineHelper(cur.getRight(), cur, key, value);
    }
    @Override
    public V getValue(K key) {
        TreeNode<KeyValuePair<K,V>> cur = root;
	while(cur != null && !cur.getValue().getKey().equals(key)){
            if(cur.getValue().getKey().compareTo(key) >= 0)cur = cur.getLeft();
            else cur = cur.getRight();
        }
        if(cur == null)return null;
        else return cur.getValue().getValue();
    }
    
    
    private KeyValuePair<K, V> deleteNode(TreeNode<KeyValuePair<K,V>> cur,TreeNode<KeyValuePair<K,V>> par){
        KeyValuePair ans = cur.getValue();
        if(cur.getLeft() == null && cur.getRight() == null)cur = null;
        else if(cur.getLeft() == null && cur.getRight() != null)cur = cur.getRight();
        else cur = cur.getLeft();
        if(par == null)root = cur;
        else{
            if(par.getValue().getKey().compareTo(ans.getKey()) >= 0)par.setLeft(cur);
            else par.setRight(cur);
        }
        size--;
        return ans;
    }
    private KeyValuePair<K, V> getTreeMin(TreeNode<KeyValuePair<K,V>> cur,TreeNode<KeyValuePair<K,V>> par){
        if(cur.getLeft() != null)return getTreeMin(cur.getLeft(), cur);
        else return deleteNode(cur, par);
    }
    @Override
    public V remove(K key) {
	TreeNode<KeyValuePair<K,V>> cur = root, par = null;
	while(cur != null && !cur.getValue().getKey().equals(key)){
            par = cur;
            if(cur.getValue().getKey().compareTo(key) > 0)cur = cur.getLeft();
            else cur = cur.getRight();
        }
        if(cur == null)return null;
        V ans = cur.getValue().getValue();
        if(cur.getLeft() == null || cur.getRight() == null)deleteNode(cur, par);
        else cur.setValue(getTreeMin(cur, par));
	return ans;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
	if(size == 0)throw new Exception("Imposssible to remove!");
	return getTreeMin(root, null);
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
    
    private String findString(TreeNode<KeyValuePair<K,V>> nd){
        if(nd == null)return "";
        else return findString(nd.getLeft()) + nd.toString() + " " + findString(nd.getRight());
    }
}
