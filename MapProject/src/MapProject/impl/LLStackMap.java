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
public class LLStackMap<K, V> implements Map<K, V> {
    private LinkedListStack<KeyValuePair<K, V> > pairs;
    
    public LLStackMap(){
        pairs = new LinkedListStack();
    }
    
    @Override
    public void define(K key, V value) {
        remove(key);
        pairs.push(new KeyValuePair(key, value));
    }

    @Override
    public V getValue(K key) {
        V value = remove(key);
        if(value != null)pairs.push(new KeyValuePair(key, value));
        return value;
    }

    @Override
    public V remove(K key) {
        LinkedListStack<KeyValuePair<K, V> > temp = new LinkedListStack();
        V value = null;
        while(pairs.getSize() > 0){
            try{
                KeyValuePair<K, V> top = pairs.pop();
                if(top.getKey().equals(key))value = top.getValue();
                else temp.push(top);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        while(temp.getSize() > 0){
            try{
                pairs.push(temp.pop());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return value;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        return pairs.pop();
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
        return res.substring(5, res.length() - 3);
    }
}
