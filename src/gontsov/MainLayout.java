package gontsov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainLayout extends JPanel implements MouseListener, MouseMotionListener{

    int x = 0, y = 0;
    boolean flag = false;

    public MainLayout() {
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
        flag = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        flag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(flag == true) {
            Graphics2D graphics2D = (Graphics2D) getGraphics();
            graphics2D.setColor(Color.black);
            graphics2D.drawLine(x,y,e.getX(),e.getY());
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
