
package robot_world;

import LastLesson.adt.Stack;
import LastLesson.impl.ArrayListStack;
import java.io.IOException;

public class SuperRobotWorld extends RobotWorld {
    
    private Stack<Character> undo, redo;
	// TODO: Add some fields to keep track of commands
	
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);//super must be first statement
        undo = new ArrayListStack();
        redo = new ArrayListStack();
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        try{
            char ch;
            if(undo.getSize() > 0)ch = undo.pop();
            else return;
            redo.push(ch);
            switch(ch){
                case 'C':
                    super.rotateCounterClockwise();
                    break;
                case 'T':
                    super.rotateClockwise();
                    break;
                case 'M'://Need to fix the case with the goal
                    super.rotateClockwise();
                    super.rotateClockwise();
                    super.moveForward();
                    super.rotateClockwise();
                    super.rotateClockwise();
                    break;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
    	for(int i=0;i<n;i++){
            undoCommand();
        }
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        try{
            char ch;
            if(redo.getSize() > 0)ch = redo.pop();
            else return;
            switch(ch){
                case 'C':
                    super.rotateClockwise();
                    break;
                case 'T':
                    super.rotateCounterClockwise();
                    break;
                case 'M':
                    super.moveForward();
                    break;
            }
            undo.push(ch);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
    	for(int i=0;i<n;i++){
            redoUndoneCommand();
        }
    }
    
    @Override
    public void rotateClockwise() {
        super.rotateClockwise();
        undo.push('C');
        redo.clear();
    }
    @Override
    public void rotateCounterClockwise() {
        super.rotateCounterClockwise();
        undo.push('T');
        redo.clear();
    }
    @Override
    public void moveForward() throws Exception {
        super.moveForward();
        undo.push('M');
        redo.clear();
    }
}
