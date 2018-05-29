/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Set_Project.impl;

/**
 *
 * @author Nurtas
 */
public class Student implements Comparable<Student>{
    private int ID;
    String name;
    
    public Student(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public int compareTo(Student obj) {
        return name.compareTo(obj.getName());
        
//        if(ID > obj.getID())return 1;
//        else if(ID < obj.getID())return -1;
//        else return 0;
        
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student st = (Student) obj;
            return ID == st.getID() && name.equals(st.getName());
        }
        return false;
    }
    
    @Override
    public String toString(){
        return  name + ", ID: " + ID + ";";
    }
    
}
