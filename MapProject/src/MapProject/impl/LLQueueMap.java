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
public class LLQueueMap<K, V> implements Map<K, V> {
    private LinkedListQueue<KeyValuePair<K, V> > pairs;
    
    public LLQueueMap(){
        pairs = new LinkedListQueue();
    }
    
    @Override
    public void define(K key, V value) {
        remove(key);
        pairs.enqueue(new KeyValuePair(key, value));
    }

    @Override
    public V getValue(K key) {
        V value = remove(key);
        if(value != null)pairs.enqueue(new KeyValuePair(key, value));
        return value;
    }

    @Override
    public V remove(K key) {
        for(int i=0;i<pairs.getSize();i++){
            try{
                KeyValuePair<K, V> next = pairs.dequeue();
                if(next.getKey().equals(key))return next.getValue();
                pairs.enqueue(next);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        return pairs.dequeue();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs.clear();
    }
    
    @Override
    public String toString(){
        String res = pairs.toString();
        return res.substring(5, res.length() - 5);
    }
}
