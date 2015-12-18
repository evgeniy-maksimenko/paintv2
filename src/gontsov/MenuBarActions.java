package gontsov;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarActions {

    LoadActionItem loadActionItem = new LoadActionItem();
    SaveActionItem saveActionItem = new SaveActionItem();

    public class LoadActionItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fs = new JFileChooser();
            if( fs.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
            {

            }
        }
    }

    public class SaveActionItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fs = new JFileChooser();
            if( fs.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
            {

            }

        }
    }
}
