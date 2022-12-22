package cis283;

public class Sphere extends Solid {
    public static final double inertiav = 0.4, minrad = 0.015, maxrad = 0.045, minmass = 0.11, maxmass = 10;

    public Sphere(double mas, double rad, double anglacc) {
        super(mas, rad, anglacc);
    }

    public double getInertia() {
        return inertiav * getMass() * (getRadius() * getRadius());
    }

    public double getTorque() {
        return getInertia() * getAngularAcceleration();
    }

    public static boolean checkMass(double mass) {
        return mass >= minmass && mass <= maxmass;
    }

    public static boolean checkRadius(double radius) {
        return radius >= minrad && radius <= maxrad;
    }

    public double getAngularAcceleration() {
        return super.getAngularAcceleration();
    }

    public double getMass() {
        return super.getMass();
    }

    public double getRadius() {
        return super.getRadius();
    }

    public void setMass(double mas) {
        super.setMass(mas);
    }

    public void setRadius(double rad) {
        super.setRadius(rad);
    }

    public void setAngularAcceleration(double acc) {
        super.setAngularAcceleration(acc);
    }

}