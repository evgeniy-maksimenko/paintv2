package gontsov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainLayout extends JPanel implements MouseListener, MouseMotionListener {

    int x = 0, y = 0;


    Config config;

    public MainLayout(Config config) {
        setBounds(50, 0, 600, 400);
        this.config = config;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        config.list.add(new Line(x, y, e.getX(), e.getY(), config.type));
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (Line p : config.list) {
            switch (p.type) {
                case 1:
                    graphics2D.drawRect(p.x1, p.y1, p.x2, p.y2);
                    break;
                case 2:
                    graphics2D.drawOval(p.x1, p.y1, p.x2, p.y2);
                    break;
            }
        }
    }
}
