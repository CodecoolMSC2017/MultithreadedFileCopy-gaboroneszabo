package com.codecool.gui;

import com.codecool.action.GetDirectoryPathFromChooser;
import com.codecool.action.GetPathFromFileChooser;
import com.codecool.action.OnCopyCommand;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyPanel extends JPanel {
    JProgressBar jp = new JProgressBar();
    JLabel source = new JLabel("source path");
    JLabel out = new JLabel("destination path");
    JTextField path = new JTextField();
    JTextField destination = new JTextField();
    JButton start = new JButton("start");
    JButton fromSelect = new JButton("open browser");
    JButton toSelect = new JButton("open browser");
    static JFileChooser fileChooser = new JFileChooser();

   public CopyPanel() {
       this.setLayout(new GridLayout(3, 4));
       //this.setSize(800, 600);
       start.addActionListener(new OnCopyCommand(this));
       fromSelect.addActionListener(new GetPathFromFileChooser(fileChooser, path));
       toSelect.addActionListener(new GetDirectoryPathFromChooser(new JFileChooser(), destination));

       this.add(fromSelect);
       this.add(source);
       this.add(path);
       this.add(toSelect);
       this.add(out);
       this.add(destination);
       this.add(start);
       this.add(jp);
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

