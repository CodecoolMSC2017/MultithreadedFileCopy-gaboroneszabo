package com.codecool.action;

import com.codecool.gui.CopyPanel;
import com.codecool.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCopyPanel implements ActionListener {

    private MainFrame frame;

    public AddCopyPanel(MainFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            public void run() {
                frame.add(new CopyPanel());
                frame.setVisible(true);
            }
        }).start();
    }
}
