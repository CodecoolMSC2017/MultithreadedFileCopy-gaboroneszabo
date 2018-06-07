package com.codecool.filetransfer;

import java.io.*;

public class FileTrasfer implements Runnable{

    private String source;
    private  String destination;
    private int progress;
    private CopyStatus copyStatus;
    private CopyObserver observer;

    public FileTrasfer(String source, String destination) {
        this.source = source;
        this.destination = destination;
        copyStatus = CopyStatus.WAITING;
    }

    public void setObserver(CopyObserver observer) {
        this.observer = observer;
    }

    void copy() throws IOException {
        setCopyStatus(CopyStatus.INPROGRESS);
        File inputFile = new File(source);
        File outputFile = new File(destination);

        long size = inputFile.length();
        long current = 0;

        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);

        byte[] buffer = new byte[1024];

        int length;
        Double d;
        while((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
            current += buffer.length;
            d = current * 1.0 / size  * 100;
            progress = d.intValue();
            observer.progressChanged(progress);
        }
    }

    private void setCopyStatus(CopyStatus copyStatus) {
        this.copyStatus = copyStatus;
        observer.copyStatusChanged(copyStatus);
    }

    public void run() {
        try {
            copy();
            setCopyStatus(CopyStatus.DONE);
        } catch (IOException e) {
            setCopyStatus(CopyStatus.FILENOTFOUND);
        }
    }
}
