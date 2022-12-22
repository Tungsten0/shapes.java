package cis283;

public class Solid {
    private double mass, radius, angular_acceleration;

    public Solid(double mas, double rad, double anglacc) {
        this.mass = mas;
        this.radius = rad;
        this.angular_acceleration = anglacc;
    }

    public Solid() {
        this.mass = 0;
        this.radius = 0;
        this.angular_acceleration = 0;
    }

    public double getInertia() {
        return getMass() * (getRadius() * getRadius());
    }

    public double getTorque() {
        return getInertia() * getAngularAcceleration();
    }

    public double getAngularAcceleration() {
        return this.angular_acceleration;
    }

    public double getMass() {
        return this.mass;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setMass(double mas) {
        this.mass = mas;
    }

    public void setRadius(double rad) {
        this.radius = rad;
    }

    public void setAngularAcceleration(double anglacc) {
        this.angular_acceleration = anglacc;
    }

}