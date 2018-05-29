package trainproject;


public class Boxcar {
    
    private final String cargo;
    private Caboose caboose;
    
    public Boxcar(String cg) {
        cargo = cg;
        caboose = null;
    }
    
    public void setCaboose(Caboose cab) {
        caboose = cab;  
    }
    
    public Caboose getCaboose() {
        return caboose;
    }
    
    @Override
    public String toString() {
        return "Boxcar is carrying " + cargo;
    }
}
