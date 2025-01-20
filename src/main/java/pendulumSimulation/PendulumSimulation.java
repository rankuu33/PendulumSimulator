package pendulumSimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PendulumSimulation extends JPanel implements ActionListener {

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 700;

    private final List<Pendulum> pendulums;
    private final Timer timer;

    public PendulumSimulation() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);

        pendulums = new ArrayList<>();

        pendulums.add(new Pendulum(PANEL_WIDTH / 2, 50, 150, Math.PI / 4, Color.RED));
        pendulums.add(new Pendulum(PANEL_WIDTH / 2, 50, 200, Math.PI / 6, Color.BLUE));
        pendulums.add(new Pendulum(PANEL_WIDTH / 2, 50, 250, Math.PI / 3, Color.GREEN));
        pendulums.add(new Pendulum(PANEL_WIDTH / 2, 50, 300, Math.PI / 8, Color.YELLOW));
        pendulums.add(new Pendulum(PANEL_WIDTH / 2, 50, 180, Math.PI / 2, Color.ORANGE));

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Pendulum pendulum : pendulums) {
            pendulum.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pendulum pendulum : pendulums) {
            pendulum.update();
        }
        repaint();
    }
}

