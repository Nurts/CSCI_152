package trainproject;


public class Caboose {
    
    private final int id;
    
    public Caboose(int num) {
        id = num;
    }
    
    @Override
    public String toString() {
        return "Caboose number " + id;
    }
}
