
package Set_Project.impl;

/**
 * Node class for creating generic binary trees
 */
public class OnOffTreeNode<T> {

    private T value;
    private int childAmt;
    private boolean active;
    
    private OnOffTreeNode<T> left;
    private OnOffTreeNode<T> right;
    
    /**
     * Construct a tree node with the given value, 
     * and null children links
     * 
     * @param val to set on the node
     */
    public OnOffTreeNode(T val) {
        value = val;
        childAmt = 0;
        left = null;
        right = null;
        active = true;
    }
    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }
    /**
     * set active field to true
     */
    public void switchOn() {
        active = true;
    }
    /**
     * set active field to false
     */
    public void switchOff() {
        active = false;
    }
    /**
     * @return the childAmt
     */
    public int getChildAmt() {
        return childAmt;
    }
    /**
     * @param val the child amount to set
     */
    public void setChildAmt(int val){
        childAmt = val;
    }
    public void inc(){
        childAmt++;
    }
    
    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the left
     */
    public OnOffTreeNode<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(OnOffTreeNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public OnOffTreeNode<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(OnOffTreeNode<T> right) {
        this.right = right;
    }
        
    /**
     * @return the string representation of the value 
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
