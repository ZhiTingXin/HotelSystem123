package testAll;

import PO.ClassToGreId;
import other.hibernateUtil;

public class tester {

	public static void main(String[] args){
		ClassToGreId classToGreId = new ClassToGreId();
		classToGreId.setId("151250000");
		classToGreId.setNeverChanged("1");
		hibernateUtil.add(classToGreId);
	}
}
