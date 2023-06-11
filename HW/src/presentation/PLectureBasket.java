package presentation;

import java.util.Vector;

import valueObject.VLecture;

public class PLectureBasket {

	private Vector<VLecture> vLectureVector;
	
	public PLectureBasket(){
		this.vLectureVector = new Vector<VLecture>();
	}
	public void add(VLecture vLecture) {
		this.vLectureVector.add(vLecture);
	}
	public void show() {
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
	}

}
