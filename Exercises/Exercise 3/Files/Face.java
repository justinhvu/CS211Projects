public class Face
{
    //fields
    private Point a;
    private Point b;
    private Point c;

    public Face(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
        double side1 = a.distance(b);
        double side2 = b.distance(c);
        double side3 = c.distance(a);

        if (area() == 0) {
            throw new FaceException("A face can't have a zero area");
        }

        if ((side1 != side2) || (side2 != side3) || (side3 != side1)) {
            throw new FaceException("Points must be equidistant");
        }
    }

    @Override
    public String toString() {
        return ("["+this.a.toString()+"-"+this.b.toString()+"-"+this.c.toString()+"]");
    }

    @Override
    public boolean equals(Object o) {
        //to check points
                //a = a; b = b; c = c; done
                //a = a; b = c; c = b;
                //a = b; b = a; c = c; 
                //a = b; b = c; c = a; done
                //a = c; b = a; c = b; done
                //a = c; b = b; c = a;
        if (!(o instanceof Face)) {
            return false;
        }
        else {
            byte count = 0;
            Face other = (Face)o;
            Point[] thisPoints = {this.a, this.b, this.c};
            Point[] otherPoints = {other.a, other.b, other.c};
            
            for (int i = 0; i < thisPoints.length; i++) {
                for (int j = 0; j < otherPoints.length; j++) {
                    if ((otherPoints[j] != null) && thisPoints[i].equals(otherPoints[j])) {
                        count++;
                        otherPoints[j] = null;
                        break;
                    }
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean adjacent(Face other) {
        //to check edges
            //check if point a and b of this is equal to a and b of other done
            //check if point a and b of this is equal to b and a of other done
            //check if point a and b of this is equal to a and c of other done
            //check if point a and b of this is equal to c and a of other done
            //check if point a and b of this is equal to b and c of other done
            //check if point a and b of this is equal to c and b of other done

            //check if point b and a of this is equal to a and c of other done
            //check if point b and a of this is equal to c and a of other done
            //check if point b and a of this is equal to b and c of other done
            //check if point b and a of this is equal to c and b of otherdone

            //check if point a and c of this is equal to a and c of other done
            //check if point a and c of this is equal to c and a of other done
            //check if point a and c of this is equal to b and c of other done
            //check if point a and c of this is equal to c and b of other done

            //check if point c and a of this is equal to b and c of other done
            //check if point c and a of this is equal to c and b of other done

            //check if point b and c of this is equal to b and c of other done
            //check if point b and c of this is equal to c and b of other done


        if (equals(other)) {
            return false;
        }

        Point[] thisPoints = {this.a, this.b, this.c, this.a};
        Point[] otherPoints = {other.a, other.b, other.c, other.a};

        for (int i = 0; i < thisPoints.length - 1; i++) {
            for (int j = 0; j < otherPoints.length - 1; j++) {
                if (thisPoints[i].equals(otherPoints[j]) && thisPoints[i+1].equals(otherPoints[j+1])) {
                    return true;
                }
                else if (thisPoints[i].equals(otherPoints[j+1]) && thisPoints[i+1].equals(otherPoints[j])) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public double edge() {
        return (a.distance(b));
    }

    public double area() {
        return (Math.sqrt(3)/4) * Math.pow(edge(), 2);
    }
}