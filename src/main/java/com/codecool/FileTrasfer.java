package com.codecool;

import java.io.*;

public class FileTrasfer {

    private String source;
    private  String destination;
    private int progress;

    public FileTrasfer(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }


    void copy() throws IOException {
        File inputFile = new File(source);
        File outputFile = new File(destination);

        long size = inputFile.length();
        long current = 0;

        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);

        byte[] buffer = new byte[1024];

        int length;

        while((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
            current += buffer.length;
            Double d;
            d = current * 1.0 / size  * 100;
            progress = d.intValue();
        }
    }

    private void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}
