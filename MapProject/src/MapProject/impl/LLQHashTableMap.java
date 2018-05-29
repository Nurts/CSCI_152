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
public class LLQHashTableMap<K, V> implements HashTableMap<K, V> {
    private LinkedListQueue<KeyValuePair<K,V> >[] buckets;
    private int size;

    public LLQHashTableMap(int k){
        buckets = new LinkedListQueue[k];
        size = 0;
    }
    private int getPosition(K key){
        int hash = key.hashCode();
        return ((hash < 0) ? -hash : hash) % buckets.length;
    }
    @Override
    public void define(K key, V value) {
        int pos = getPosition(key);
        if(buckets[pos] == null)buckets[pos] = new LinkedListQueue();
        else remove(key);
        buckets[pos].enqueue(new KeyValuePair(key,value));
        size++;
    }

    @Override
    public V getValue(K key) {
        int pos = getPosition(key);
        V value = remove(key);
        if(value != null){
            size++;
            buckets[pos].enqueue(new KeyValuePair(key,value));
        }
        return value;
    }

    @Override
    public V remove(K key) {
        int pos = getPosition(key);
        if(buckets[pos] == null || buckets[pos].getSize() == 0)return null;
        for(int i=0;i<buckets[pos].getSize();i++){
            try{
                KeyValuePair<K, V> next = buckets[pos].dequeue();
                if(next.getKey().equals(key)){
                    size--;
                    return next.getValue();
                }
                buckets[pos].enqueue(next);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0)throw new Exception("The Map is Empty!");
        size--;
        for(int i=0;i<buckets.length;i++){
            if(buckets[i] != null && buckets[i].getSize() > 0)return buckets[i].dequeue();
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[buckets.length];
        size = 0;
    }
    
    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index >= buckets.length || index < 0)throw new Exception("The index is out of range!");
        if(buckets[index] == null)return 0;
        else return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return (double) size / buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double sum = 0.0;
        for(int i=0;i<buckets.length;i++){
             if(buckets[i] != null)sum += (buckets[i].getSize() - getLoadFactor()) * (buckets[i].getSize() - getLoadFactor());
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
                String str = buckets[i].toString();
                res += str.substring(8, str.length() - 7);
            }
            res += "\n";
            
        }
        return res;
    }
    
    @Override
    public String toString(){
        String res = "[ ";
        for(int i=0;i<buckets.length;i++){
            if(buckets[i] != null){
                String str = buckets[i].toString();
                res += str.substring(8, str.length() - 7);
            }
            
        }
        return res + "]";
    }
}
