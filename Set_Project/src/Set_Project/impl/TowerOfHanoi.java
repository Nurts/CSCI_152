
package Set_Project.impl;

import Set_Project.adt.Stack;


public class TowerOfHanoi {

	private Stack<Integer>[] post = new ArrayStack[3];
	private int numMoves = 0;
	
	public TowerOfHanoi(int numDiscs) {
                post[0] = new ArrayStack();
                post[1] = new ArrayStack();
                post[2] = new ArrayStack();
                for(int i = numDiscs;i > 0;i--){
                    post[0].push(i);
                }
		/*
		 TODO: Initialize all three posts to new stack objects,
		 and push onto post[0] the integers:
		    numDiscs, numDiscs-1, numDiscs-2, ..., 1 
		 */
	}
	
	public void moveDisc(int from, int to) throws Exception {
                if(from < 3 && from >= 0 && to < 3 && from >= 0 && post[from].getSize() != 0){
                    int p1 = post[from].pop(), p2 = -1;
                    if(post[to].getSize() > 0) p2 = post[to].pop();
                    if(p2 == -1 || p1 < p2){
                        if(p2 != -1)post[to].push(p2);
                        post[to].push(p1);
                        numMoves++;
                        return;
                    }
                }
                throw new Exception("Impossible to move Disc!");
		/* 
		 TODO:  Moves the integer from the top of post[from] to 
		 post[to].  Throws an exception if either index is not
		 0, 1, or 2; or if post[from] is empty; or if the value
		 on top of post[from] is bigger than the topmost item of
		 post[to].
		 */
	}
	
	public boolean isFinished() {
            /*
            TODO:  Returns true if and only if all of the discs are
            on post[2] (i.e., post[0] and post[1] are empty)
             */ 

		return post[0].getSize() == 0 && post[1].getSize() == 0;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
        @Override
	public String toString() {
            String res = "";
            for(int i=0;i<3;i++){
                res += "Tower " + (i+1) + ": " + post[i].toString() + "\n";
            }
            
		/* 
		 TODO:  Returns some string representation of the current
		 game state.... this should help with debugging
		 */
		return res;
	}
	
}
