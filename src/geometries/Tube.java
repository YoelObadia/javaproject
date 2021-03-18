package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

public abstract class Tube implements Geometry{
    Ray _axisRay;
    double _radius;

    public Tube(Ray axisRay, double radius) {
        this._axisRay = axisRay;
        this._radius = radius;
    }

    public Ray getAxisRay() {
        return _axisRay;
    }

    public double getRadius() {
        return _radius;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        double t = _axisRay.getVec().dotProduct(p.subtract(_axisRay.getPoint()));
        Point3D o = _axisRay.getPoint().add(_axisRay.getVec().scalar(t));

        return p.subtract(o).normalized();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tube tube = (Tube) o;
        return Double.compare(tube._radius, _radius) == 0 && _axisRay.equals(tube._axisRay);
    }

    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }
}
