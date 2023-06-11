package model;

import global.Locale;
import valueObject.VLecture;

import java.io.*;
import java.util.Vector;

public class MLecture {
    private Vector<VLecture> vLectures;
    public Vector<VLecture> getDirectories(String fileName) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(Locale.PATH+fileName+".txt"));
            vLectures = new Vector<>();

            while(bf.ready()){
                String fileInfo = bf.readLine();
                if(!fileInfo.equals(Locale.BLANK)) this.vLectures.add(new VLecture(fileInfo));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vLectures;
    }

    public void save (String fileName, Vector<VLecture> vLectures) throws IOException {
    	File file = new File(Locale.PATH+fileName);
    	file.delete();
    	if(!file.exists()) file.createNewFile();
    	
    	BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        for(VLecture vLecture : vLectures){
            bw.write(vLecture.getString());
            bw.newLine();
        }bw.close();
    }
}
