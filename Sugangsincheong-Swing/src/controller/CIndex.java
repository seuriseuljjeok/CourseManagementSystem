package controller;
import model.MIndex;
import valueObject.VIndex;

import java.io.IOException;
import java.util.Vector;

public class CIndex {
    private MIndex mIndex;
    private VIndex vIndex;

    public CIndex() {
        this.mIndex = new MIndex();
        this.vIndex = new VIndex();
    }

    public Vector<VIndex> getDirectories(String fileName) throws IOException {
        return this.mIndex.getDirectories(fileName);
    }

    public String getFileName() {
        return this.vIndex.getFileName();
    }
}