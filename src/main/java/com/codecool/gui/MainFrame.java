package com.codecool.gui;

import com.codecool.action.AddCopyPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    int width;
    int height;
    JButton add = new JButton("add");

    public MainFrame(int width, int height) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.setLayout(new FlowLayout());
        this.add(add);
        add.addActionListener(new AddCopyPanel(this));

        this.setVisible(true);

    }
}
