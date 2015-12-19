package gontsov;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Container extends JFrame {

    BufferedImage image;
    Config config;

    public Container() {


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 640, 480);

        config = new Config();

        add(new MainLayout(config));


        setLayout(null);

        JButton btn1 = new JButton("rect");
        JButton btn2 = new JButton("oval");
        JButton btn3 = new JButton("tJson");
        JButton btn4 = new JButton("fJson");

        btn1.setBounds(0, 50, 50, 50);
        btn2.setBounds(0, 100, 50, 50);
        btn3.setBounds(0, 150, 50, 50);
        btn4.setBounds(0, 200, 50, 50);


        btn1.addActionListener(new Btn1Rect());
        btn2.addActionListener(new Btn2Rect());
        btn3.addActionListener(new Btn3Rect());
        btn4.addActionListener(new Btn4Rect());

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");

        loadItem.addActionListener(new LoadActionItem());

        menu.add(loadItem);
        menu.add(saveItem);

        setVisible(true);
    }

    public class LoadActionItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fo = new JFileChooser();
            if (fo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    image = ImageIO.read(fo.getSelectedFile());
                    repaint();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private class Btn1Rect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            config.type = 1;
        }
    }

    private class Btn2Rect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            config.type = 2;
        }
    }

    private class Btn3Rect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String json = new Gson().toJson(config.list);
            saveToFile("list.json", json);
            System.out.println("save to file:" + json);
            JOptionPane.showMessageDialog(null, "Success save to file list.json");

        }
    }

    private class Btn4Rect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            BufferedReader br = null;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("list.json"));
                Gson gson = new Gson();
                ArrayList<Line> result = gson.fromJson(reader, new TypeToken<ArrayList<Line>>(){}.getType());
                for (Line aResult : result) {
                    config.list.add(new Line(aResult.x1, aResult.y1, aResult.x2, aResult.y2, aResult.type));
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

            repaint();






        }
    }

    public void saveToFile(String Name, String Body) {

        try {
            File newTextFile = new File(Name);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Body);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String Name) {

        String result = "";

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(Name));
            String currentLine;
            while ((currentLine = buffer.readLine()) != null) {
                return currentLine;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
