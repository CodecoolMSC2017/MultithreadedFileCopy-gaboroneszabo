package com.codecool.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetPathFromFileChooser implements ActionListener {

    private JFileChooser jFileChooser;
    private JTextField jTextField;

    public GetPathFromFileChooser(JFileChooser jFileChooser, JTextField jTextField) {
        this.jFileChooser = jFileChooser;
        this.jTextField = jTextField;
    }

    public void actionPerformed(ActionEvent e) {

        int status = jFileChooser.showOpenDialog(null);
        if (status ==JFileChooser.APPROVE_OPTION) {
            jTextField.setText(jFileChooser.getSelectedFile().getAbsolutePath());
        }
    }
}
