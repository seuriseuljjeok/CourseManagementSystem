package controller;

import model.MLecture;
import valueObject.VLecture;

import java.util.Vector;

public class CLecture {
    private MLecture mLecture;
    public CLecture(){
        this.mLecture = new MLecture();
    }
    public Vector<VLecture> getLectures(String fileName){
        return this.mLecture.getDirectories(fileName);
    }
    
}

