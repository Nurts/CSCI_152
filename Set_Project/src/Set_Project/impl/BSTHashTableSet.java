/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.impl;

import Set_Project.adt.HashTableSet;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T>{
    private BSTSet<T>[] buckets;
    private int size;
    
    public BSTHashTableSet(int k){
        buckets = new BSTSet[k];
        size = 0;
    }
    
    private int getPosition(T value){
        int hash = value.hashCode();
        return ((hash < 0) ? -hash : hash) % buckets.length;
    }
    
    @Override
    public void add(T value) {
        int idx = getPosition(value);
        if(buckets[idx] == null){
            buckets[idx] = new BSTSet();
            buckets[idx].add(value);
            size++;
        }
        else{
            int sz = buckets[idx].getSize();
            buckets[idx].add(value);
            size += (buckets[idx].getSize() - sz);
        }
    }

    
    @Override
    public boolean contains(T value) {
        int idx = getPosition(value);
        if(buckets[idx] == null)return false;
        else return buckets[idx].contains(value);
    }

    @Override
    public boolean remove(T value) {
        int idx = getPosition(value);
        if(buckets[idx] != null && buckets[idx].remove(value)){
            size--;
            return true;
        }
        else return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0)throw new Exception("The Set is Empty!");
        size--;
        for(int i=0;i<buckets.length-1;i++){
            if(buckets[i] != null && buckets[i].getSize() > 0)return buckets[i].removeAny();
        }
        return buckets[buckets.length - 1].removeAny();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new BSTSet[buckets.length];
    }
    
    @Override
    public String toString(){
        String res = "Set: [";
        for(int i=0;i<buckets.length;i++){
            if (buckets[i] != null) {
                String str = buckets[i].toString();
                res += str.substring(1, str.length()-2);
            }
        }
        return res +" ]";
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index < 0 || buckets.length <= index)throw new Exception("The index is not in Range!");
        return buckets[index].getSize();
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
             else sum+= getLoadFactor() *getLoadFactor();
        }
        return sqrt(sum / buckets.length);
    }

    @Override
    public String bucketsToString() {
        String res = "Set:\n";
        for(int i=0;i<buckets.length;i++){
            res += i + ": ";
            if(buckets[i] != null){
                res += buckets[i].toString();
                
            }
            res += "\n";
        }
        return res;
    }

    
    
}
