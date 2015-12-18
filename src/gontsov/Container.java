package gontsov;

import javax.swing.*;

public class Container extends JFrame{
    public Container(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,640,480);
        add(new MainLayout());
        setVisible(true);

        MenuBarActions menuBarActions = new MenuBarActions();

        MainMenuBar menuBar = new MainMenuBar(menuBarActions);
        setJMenuBar(menuBar);
    }
}
