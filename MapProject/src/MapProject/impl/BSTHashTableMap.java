/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapProject.impl;

import MapProject.adt.HashTableMap;
import static java.lang.Math.sqrt;

/**
 *
 * @author Nurtas
 * @param <K>
 * @param <V>
 */
public class BSTHashTableMap<K extends Comparable, V> implements HashTableMap<K, V> {
    private TreeNode< KeyValuePair<K, V> >[] buckets;
    private int size;
    private int[] bucketSize;
    
    public BSTHashTableMap(int k){
        size = 0;
        buckets = new TreeNode[k];
        bucketSize = new int[k];
    } 
    private int getPosition(K key){
        int hash = key.hashCode();
        return ((hash < 0) ? -hash : hash) % buckets.length;
    }
    @Override
    public void define(K key, V value) {
        int pos = getPosition(key);
        if(buckets[pos] == null){
            bucketSize[pos] = 1;
            buckets[pos] = new TreeNode(new KeyValuePair(key, value));
            size++;
        }
        else defineHelper(buckets[pos], null, key, value, pos);
    }
    private void defineHelper(TreeNode<KeyValuePair<K,V>> cur, TreeNode<KeyValuePair<K,V>> par, K key, V value, int pos){
        if(cur == null){
            size++;
            bucketSize[pos]++;
            if(par.getValue().getKey().compareTo(key) >= 0)par.setLeft(new TreeNode(new KeyValuePair(key, value)));
            else par.setRight(new TreeNode(new KeyValuePair(key, value)));
        }
        else if(cur.getValue().getKey().equals(key))cur.setValue(new KeyValuePair(key, value));
        else if(cur.getValue().getKey().compareTo(key) >= 0)defineHelper(cur.getLeft(), cur, key, value, pos);
        else defineHelper(cur.getRight(), cur, key, value, pos);
    }
    @Override
    public V getValue(K key) {
        int pos = getPosition(key);
        TreeNode<KeyValuePair<K,V>> cur = buckets[pos];
	while(cur != null && !cur.getValue().getKey().equals(key)){
            if(cur.getValue().getKey().compareTo(key) >= 0)cur = cur.getLeft();
            else cur = cur.getRight();
        }
        if(cur == null)return null;
        else return cur.getValue().getValue();
    }
    
    private KeyValuePair<K, V> deleteNode(TreeNode<KeyValuePair<K,V>> cur,TreeNode<KeyValuePair<K,V>> par, int pos){
        KeyValuePair ans = cur.getValue();
        if(cur.getLeft() == null && cur.getRight() == null)cur = null;
        else if(cur.getLeft() == null && cur.getRight() != null)cur = cur.getRight();
        else cur = cur.getLeft();
        if(par == null)buckets[pos] = cur;
        else{
            if(par.getValue().getKey().compareTo(ans.getKey()) >= 0)par.setLeft(cur);
            else par.setRight(cur);
        }
        size--;
        bucketSize[pos]--;
        return ans;
    }
    private KeyValuePair<K, V> getTreeMin(TreeNode<KeyValuePair<K,V>> cur,TreeNode<KeyValuePair<K,V>> par, int pos){
        if(cur.getLeft() != null)return getTreeMin(cur.getLeft(), cur, pos);
        else return deleteNode(cur, par, pos);
    }
    @Override
    public V remove(K key) {
        int pos = getPosition(key);
        TreeNode<KeyValuePair<K,V>> cur = buckets[pos], par = null;
	while(cur != null && !cur.getValue().getKey().equals(key)){
            par = cur;
            if(cur.getValue().getKey().compareTo(key) > 0)cur = cur.getLeft();
            else cur = cur.getRight();
        }
        if(cur == null)return null;
        V ans = cur.getValue().getValue();
        if(cur.getLeft() == null || cur.getRight() == null)deleteNode(cur, par, pos);
        else cur.setValue(getTreeMin(cur, par, pos));
	return ans;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0)throw new Exception("The Map is Empty!");
        size--;
        for(int i=0;i<buckets.length;i++){
            if(buckets[i] != null && bucketSize[i] > 0)return getTreeMin(buckets[i], null, i);
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        bucketSize = new int[buckets.length];
        buckets = new TreeNode[buckets.length];
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index >= buckets.length || index < 0)throw new Exception("The index is out of range!");
        if(buckets[index] == null)return 0;
        else return bucketSize[index];
    }

    @Override
    public double getLoadFactor() {
        return (double) size / buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double sum = 0.0;
        for(int i=0;i<buckets.length;i++){
             if(buckets[i] != null)sum += (bucketSize[i] - getLoadFactor()) * (bucketSize[i] - getLoadFactor());
             else sum += getLoadFactor() * getLoadFactor();
        }
        return sqrt(sum / buckets.length);
    }

    @Override
    public String bucketsToString() {
        String res = "Buckets:\n";
        for(int i=0;i<buckets.length;i++){
            res += i + ": ";
            if(buckets[i] != null){
                res +=  findString(buckets[i]);
            }
            res += "\n";
            
        }
        return res;
    }
    @Override
    public String toString(){
        String res = "[ ";
        for(int i=0;i<buckets.length;i++){
            if(buckets[i] != null)res += findString(buckets[i]);
        }
        return res + "]";
    }
    private String findString(TreeNode<KeyValuePair<K,V>> nd){
        if(nd == null)return "";
        else return findString(nd.getLeft()) + nd.toString() + " " + findString(nd.getRight());
    }
    
}
