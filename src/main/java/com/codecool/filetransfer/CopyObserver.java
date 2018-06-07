package com.codecool.filetransfer;

public interface CopyObserver {

    void copyStatusChanged(CopyStatus copyStatus);

    void progressChanged(int progress);
}
