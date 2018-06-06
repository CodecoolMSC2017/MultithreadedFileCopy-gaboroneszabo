package com.codecool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame {

    JProgressBar jp = new JProgressBar();
    JLabel source = new JLabel("source path");
    JLabel out = new JLabel("destination path");
    JTextField path = new JTextField();
    JTextField destination = new JTextField();
    JButton start = new JButton("start");
    JFileChooser fileChooser = new JFileChooser();


    public Gui() {
        this.setLayout(new GridLayout(3, 4));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(800, 600);



        start.addActionListener(new Click(this));

        this.add(source);
        this.add(path);
        this.add(out);
        this.add(destination);
        this.add(start);
        this.add(jp);
        //this.add(fileChooser);
        this.setVisible(true);

    }

    JProgressBar getJprogressBar() {
        return jp;
    }

    String getSourcePath() {
        return path.getText();
    }

    String getDestinationPath() {
        return  destination.getText();
    }
}
