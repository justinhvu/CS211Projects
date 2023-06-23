public class Gala extends Apple {
    //weight restricted to 120grams <= x <= 150grams

    public Gala(int code, boolean organic, int weight, int density) {
        super(code, organic, weight, density);
    }

    public double volume(boolean isGala) {
        if (isGala) {
            return (super.volume() / 3.79);
        }

        return super.volume();
    }

    @Override
    public String toString() {
        if (this.organic) {
            return ("gala organic apple " + this.code);
        }

        return ("gala apple " + this.code);
    }
}