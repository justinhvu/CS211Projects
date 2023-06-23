public abstract class Fruit implements Comparable<Fruit>{
    int code;
    boolean organic;

    public Fruit(int code, boolean organic) {
        if (code < 0 || code > 99999) {
            throw new IllegalArgumentException();
        }

        this.code = code;
        this.organic = organic;
    }

    public int getCode() {
        return this.code;
    }

    public boolean getOrganic() {
        return this.organic;
    }

    public int compareTo(Fruit other) {
        return this.code - other.code;
    }
}