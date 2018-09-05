package com.codecool.action;

import javax.swing.*;

public class GetDirectoryPathFromChooser extends GetPathFromFileChooser {
    public GetDirectoryPathFromChooser(JFileChooser jFileChooser, JTextField jTextField) {
        super(jFileChooser, jTextField);
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
}

