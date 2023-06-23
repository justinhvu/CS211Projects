public class Apple extends Fruit{
    private int weight; //grams
    private int density; //grams per milliliter
    private Savor flavor;

    public Apple(int code, boolean organic, int weight, int density) {
        super(code, organic);

        if (weight < 0 || density < 0) {
            throw new IllegalArgumentException();
        }

        this.weight = weight;
        this.density = density;
    }

    public void setFlavor(Savor flavor) {
        this.flavor = flavor;
    }

    public double volume() {
        return (this.weight / this.density) / 1000;
    }

    @Override
    public String toString() {
        if (this.organic) {
            return ("organic apple " + this.code);
        }

        return ("apple " + this.code);
    }
}