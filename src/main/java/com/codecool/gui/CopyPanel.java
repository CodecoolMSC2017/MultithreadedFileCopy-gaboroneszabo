package com.codecool.gui;

import com.codecool.action.OnCopyCommand;

import javax.swing.*;
import java.awt.*;

public class CopyPanel extends JPanel {
    JProgressBar jp = new JProgressBar();
    JLabel source = new JLabel("source path");
    JLabel out = new JLabel("destination path");
    JTextField path = new JTextField();
    JTextField destination = new JTextField();
    JButton start = new JButton("start");
    JFileChooser fileChooser = new JFileChooser();

   public CopyPanel() {
       this.setLayout(new GridLayout(3, 4));
       //this.setSize(800, 600);
       start.addActionListener(new OnCopyCommand(this));
       this.add(source);
       this.add(path);
       this.add(out);
       this.add(destination);
       this.add(start);
       this.add(jp);
       //this.add(fileChooser);
       this.setVisible(true);
   }

    public JProgressBar getJprogressBar() {
        return jp;
    }

    public String getSourcePath() {
        return path.getText();
    }

    public String getDestinationPath() {
        return  destination.getText();
    }
}

