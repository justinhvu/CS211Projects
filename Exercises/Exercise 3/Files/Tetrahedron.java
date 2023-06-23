public class Tetrahedron
{
    //fields
    private Face a;
    private Face b;
    private Face c;
    private Face d;

    //constructors
    public Tetrahedron(Face a, Face b, Face c, Face d) throws TetrahedronException{

        if (!(a.adjacent(b) && a.adjacent(c) && a.adjacent(d) && b.adjacent(c) && b.adjacent(d) && c.adjacent(d))) {
            throw new TetrahedronException("The four faces do not form a tetrahedron");
        }
        Face[] faces = {a, b, c, d};
        for (int i = 0; i < faces.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                if ((i != j) && faces[i].equals(faces[j])) {
                    throw new TetrahedronException("The four faces do not form a tetrahedron");
                }
            }
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Tetrahedron(Point a, Point b, Point c, Point d) throws TetrahedronException{
        Point[] points = {a, b, c, d};
        
        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < points.length; j++) {
                if ((i != j) && points[i].distance(points[j]) != points[0].distance(points[1])) {
                    throw new TetrahedronException("The four faces do not form a tetrahedron");
                }
                if ((i != j) && points[i].equals(points[j])) {
                    throw new TetrahedronException("The four faces do not form a tetrahedron");
                }
            }
        }

        Face f1 = new Face(a, b, c);
        Face f2 = new Face(b, c, d);
        Face f3 = new Face(c, d, a);
        Face f4 = new Face(d, a, b);

        this.a = f1;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public double area() {
        return (4 * a.area());
    }

    public double volume() {
        return Math.pow((a.edge()), 3) / (6 * Math.sqrt(2));
    }
}