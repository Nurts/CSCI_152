/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.impl;

import Set_Project.adt.HashTableSet;
import static java.lang.Math.sqrt;

/**
 *
 * @author Nurtas
 * @param <T>
 */
public class LLQHashTableSet<T> implements HashTableSet<T>{
    private LinkedListQueue<T>[] buckets;
    private int size;
    
    public LLQHashTableSet(int k){
        buckets = new LinkedListQueue[k];
        size = 0;
    }
    
    private int getPosition(T value){
        int hash = value.hashCode();
        return ((hash < 0) ? -hash : hash) % buckets.length;
    }
    
    @Override
    public void add(T value) {
        
        if(contains(value))return;
        int idx = getPosition(value);
        
        if(buckets[idx] == null)buckets[idx] = new LinkedListQueue();
        buckets[idx].enqueue(value);
        size++;
    }

    @Override
    public boolean contains(T value) {
        int idx = getPosition(value);
        if(buckets[idx] == null)return false;
        for(int i=0;i<buckets[idx].getSize();i++){
            try{
                T next =  buckets[idx].dequeue();
                buckets[idx].enqueue(next);
                if(value.equals(next))return true;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int idx = getPosition(value);
        if(buckets[idx] != null){
            for(int i=0;i<buckets[idx].getSize();i++){
                try{
                    T next =  buckets[idx].dequeue();
                    if(value.equals(next)){
                        size--;
                        return true;
                    }
                    buckets[idx].enqueue(next);
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0)throw new Exception("The Set is Empty!");
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
        size = 0;
        buckets = new LinkedListQueue[buckets.length];
    }
    
    @Override
    public String toString(){
        String res = "Set: [ ";
        for(int i=0;i<buckets.length;i++){
            if (buckets[i] != null) {
                for(int j=0;j<buckets[i].getSize();j++){
                    try{
                    T next = buckets[i].dequeue();
                    res += next.toString() + " ";
                    buckets[i].enqueue(next);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        return res + "]";
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index >= buckets.length || index < 0)throw new Exception("The index is not in Range!");
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
                for(int j=0;j<buckets[i].getSize();j++){
                    try{
                        T next = buckets[i].dequeue();
                        res += next.toString() + " ";
                        buckets[i].enqueue(next);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
            res += "\n";
        }
        return res;
    }

    
    
}
