package model;

import global.Locale;
import valueObject.VIndex;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class MIndex {
    private VIndex v;
    private Vector<VIndex> vDirectories;

    public Vector<VIndex> getDirectories(String fileName){
        //filename을 읽어서 벡터를 만들어 가져와야함
        vDirectories = new Vector<>();

        try {
            File file = new File(Locale.PATH+fileName+".txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){//file이 끝날 때까지 읽어라
                v = new VIndex();
                v.read(scanner);
                vDirectories.add(v);
            }scanner.close();
        } catch (FileNotFoundException e) {e.printStackTrace();        }
        return vDirectories;
    }

    public void save (String fileName, Vector<VIndex> vDirectories) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(Locale.PATH+fileName));
        for(VIndex vDirectory : vDirectories){
            bw.write(vDirectory.getString());
            bw.newLine();
        }bw.close();
    }

}
