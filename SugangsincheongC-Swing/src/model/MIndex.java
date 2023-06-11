package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import valueObject.VIndex;

//fileName을 주면 valueObject에 한 줄씩 담아서 벡터로 넘겨주는 역할 
//DAO
public class MIndex {

	public Vector<VIndex> getVIndexVector(String fileName) {
		Vector<VIndex> vIndexVector = null;
		try {
			Scanner file = new Scanner(new File("data/"+fileName+".txt"));
		
			vIndexVector = new Vector<VIndex>();
			
			while(file.hasNext()) {
				VIndex vIndex = new VIndex();
				vIndex.load(file);
				vIndexVector.add(vIndex);
			}
			file.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return vIndexVector;		
	}

}
