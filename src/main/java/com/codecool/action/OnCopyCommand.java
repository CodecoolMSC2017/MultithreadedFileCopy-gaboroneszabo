package com.codecool.action;

import com.codecool.filetransfer.CopyObserver;
import com.codecool.filetransfer.CopyStatus;
import com.codecool.filetransfer.FileTrasfer;
import com.codecool.gui.CopyPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnCopyCommand implements ActionListener, CopyObserver {

    CopyPanel frame;

    public OnCopyCommand(CopyPanel frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String source = frame.getSourcePath();
        String dest = frame.getDestinationPath();

        String asd = "/home/gabor/Downloads/ideaIC-2018.1.3.tar.gz";

        final FileTrasfer ft = new FileTrasfer(source, dest);
        ft.setObserver(this);

        Thread copyThread = new Thread(ft);
        copyThread.start();

    }

    public void copyStatusChanged(CopyStatus copyStatus) {
        System.out.println(String.valueOf(copyStatus));
    }

    public void progressChanged(int progress) {
        frame.getJprogressBar().setValue(progress);
        frame.getJprogressBar().setString("asd");
    }
}
