
public class Cartas {
    private int up;
    private int left;
    private int down;
    private int right;


    public Cartas(){}

    public Cartas(Integer up, Integer left, Integer down, Integer right) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "up=" + up +
                ", left=" + left +
                ", down=" + down +
                ", right=" + right +
                '}';
    }
}