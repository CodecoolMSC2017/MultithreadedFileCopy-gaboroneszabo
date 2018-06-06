package com.codecool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Click implements ActionListener {

    Gui frame;

    Click(Gui frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String source = frame.getSourcePath();
        String dest = frame.getDestinationPath();

        String asd = "/home/gabor/Downloads/ideaIC-2018.1.3.tar.gz";

        final FileTrasfer ft = new FileTrasfer(source, dest);

        new Thread(new FileThread(ft)).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e1) {
                        break;
                    }
                    frame.getJprogressBar().setValue(ft.getProgress());
                }
            }
        }).start();

    }

    final class FileThread extends Thread {

        private FileTrasfer ft;

        FileThread(FileTrasfer ft) {
            this.ft = ft;
        }

        public void run() {
            try {
                ft.copy();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
