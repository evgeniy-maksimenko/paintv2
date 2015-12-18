package gontsov;

import javax.swing.*;

public class MainMenuBar extends JMenuBar{
    public MainMenuBar(MenuBarActions action){

        JMenu menu = new JMenu("File");
        add(menu);

        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");

        loadItem.addActionListener(action.loadActionItem);
        saveItem.addActionListener(action.saveActionItem);

        menu.add(loadItem);
        menu.add(saveItem);

    }
}
