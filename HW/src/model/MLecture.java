package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

//fileName을 주면 valueObject에 한 줄씩 담아서 벡터로 넘겨주는 역할 
//DAO
public class MLecture {
	public Vector<VLecture> getVLectureVector(String fileName) {
			Vector<VLecture> vLectureVector = null;
			try {
				Scanner file = new Scanner(new File("data/"+fileName+".txt"));
			
				vLectureVector = new Vector<VLecture>();
				
				while(file.hasNext()) {
					VLecture vLecture = new VLecture();
					vLecture.load(file);
					vLectureVector.add(vLecture);
				}
				file.close();
			} catch (FileNotFoundException e) {e.printStackTrace();}
			return vLectureVector;		
		}
}
