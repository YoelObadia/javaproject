package geometries;

import primitives.Point3D;
import primitives.Vector;

import java.util.Objects;

public abstract class Sphere implements Geometry{

    Point3D _center;
    double _radius;

    public Sphere(Point3D a, double r){
        this._center = a;
        this._radius = r;
    }

    public Sphere(double x, double y, double z, double r) {
        _center = new Point3D(x, y, z);
        _radius = r;
    }

    public Point3D getCenter() {
        return _center;
    }

    public double getRadius() {
        return _radius;
    }

    public Vector getNormal(Point3D p)
    {
        return p.subtract(_center).normalized();
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere._radius, _radius) == 0 && _center.equals(sphere._center);
    }
}
