
public class Cartas extends Exception{
    private String name;
    private int up;
    private int down;
    private int left;
    private int right;


    public Cartas(){}

    public Cartas(String name, Integer up, Integer left, Integer down, Integer right) {
        this.name = name;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }
    
}