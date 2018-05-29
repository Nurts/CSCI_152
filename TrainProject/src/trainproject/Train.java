package trainproject;


public class Train {
    
    private Engine engine;
    
    public Train(String ename, String carg, int cabID) {
        engine = new Engine(ename);
        engine.setBoxcar(new Boxcar(carg));
        engine.getBoxcar().setCaboose(new Caboose(cabID));
    }
    
    @Override
    public String toString() {
        
        // TODO: Fix this so that the information for all three cars are shown
        return "Train: " + engine.toString() + "; " 
                + engine.getBoxcar().toString() + "; " 
                + engine.getBoxcar().getCaboose().toString();
    }
}
