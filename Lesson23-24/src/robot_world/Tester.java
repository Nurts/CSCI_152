
package robot_world;

public class Tester {
    
    public static void main(String[] args) throws Exception {
        //Need to fix the case with the goal
        SuperRobotWorld rw = new SuperRobotWorld("src/robot_world/map1.txt");
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.printCurrentWorldMap();
        
        rw.rotateClockwise();
        rw.printCurrentWorldMap();
        
        for (int i = 0; i < 5; i++) {
        	rw.moveForward();
        	rw.printCurrentWorldMap();
        }
        
        
        rw.moveForward();
        rw.printCurrentWorldMap();
        System.out.println(" - undo");
        rw.undoCommand();
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.moveForward();
        rw.rotateClockwise();
        rw.printCurrentWorldMap();
        rw.undoCommands(2);
        System.out.println(" - double undo");
        rw.printCurrentWorldMap();
        rw.redoUndoneCommand();
        System.out.println(" - redo undone");
        rw.printCurrentWorldMap();
        //Additional;
        /*
        rw.rotateClockwise();
        for (int i = 0; i < 6; i++) {
            try{
                rw.moveForward();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        rw.printCurrentWorldMap();
        rw.rotateClockwise();
        for (int i = 0; i < 4; i++) {
            rw.moveForward();
        }
        rw.printCurrentWorldMap();
        rw.rotateClockwise();
        for (int i = 0; i < 3; i++) {
            rw.moveForward();
        }
        rw.printCurrentWorldMap();
        rw.rotateClockwise();
        for (int i = 0; i < 2; i++) {
            rw.moveForward();
        }
        rw.printCurrentWorldMap();
        rw.rotateClockwise();
        rw.rotateClockwise();
        rw.moveForward();
        rw.printCurrentWorldMap();
        //*/
    }
}
