package primitives;

import java.util.Objects;

public class Ray {
    Point3D _p0;
    Vector _dir;

    /**
     * constructor that receives a point and a vector
     * (a vector received by a constructor does not have to be normalized, but a vector stored in the beam must be normalized)
     * @param p point
     * @param d vector
     */

    public Ray(Point3D p, Vector d) {
        this._dir = d;

        if(this._dir.normalize() == this._dir)
            this._p0 = p;

        else
            this._dir.normalize();
            this._p0 = p;
            this._dir = d;
    }

    /**
     * getter point
     * @return
     */

    public Point3D getPoint() {
        return _p0;
    }

    /**
     * getter vector
     * @return
     */

    public Vector getVec() {
        return _dir;
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_p0=" + _p0 +
                ", _dir=" + _dir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals(ray._p0) && _dir.equals(ray._dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_p0, _dir);
    }
}
