package pendulumSimulation;

import java.awt.*;

public class Pendulum {
    private static final double GRAVITY = 9.81;

    private final int pivotX, pivotY;
    private final double length;
    private final Color color;
    private double angle;
    private double angularVelocity;
    private double angularAcceleration;

    public Pendulum(int pivotX, int pivotY, double length, double initialAngle, Color color) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.length = length;
        this.angle = initialAngle;
        this.color = color;
        this.angularVelocity = 0;
        this.angularAcceleration = 0;
    }

    public void update() {

        angularAcceleration = -(GRAVITY / length) * Math.sin(angle);
        angularVelocity += angularAcceleration;
        angle += angularVelocity;


        angularVelocity *= 0.99;
    }

    public void draw(Graphics g) {

        int ballX = (int) (pivotX + length * Math.sin(angle));
        int ballY = (int) (pivotY + length * Math.cos(angle));


        g.setColor(Color.WHITE);
        g.drawLine(pivotX, pivotY, ballX, ballY);


        g.setColor(color);
        g.fillOval(ballX - 15, ballY - 15, 30, 30);
    }
}


