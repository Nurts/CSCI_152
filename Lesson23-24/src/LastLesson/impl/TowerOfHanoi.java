
package LastLesson.impl;

import LastLesson.adt.Stack;


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
	}
	
	public void moveDisc(int from, int to) throws Exception {
            if(from < 3 && from >= 0 && to < 3 && to >= 0 && post[from].getSize() != 0){
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
	}
	
	public boolean isFinished() {
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
            return res;
	}
	
}
