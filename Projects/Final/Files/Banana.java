public class Banana extends Fruit {
    private final Savor taste = Savor.SWEET;
    private String origin;

    public Banana(int code, boolean organic, String origin) {
        super(code, organic);

        this.origin = origin;
    }

    @Override
    public String toString() {
        if (this.organic) {
            return ("organic banana " + this.code + " from " + this.origin);
        }

        return ("banana " + this.code + " from " + this.origin);
    }
}