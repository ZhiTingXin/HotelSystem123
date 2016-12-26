package testAll;

import java.util.ArrayList;

import PO.SuperVipPO;
import data.dao.impl.SupVipDaoImpl;

public class SuperVip {

	public static void  main( String []args) {
		SupVipDaoImpl supVipDaoImpl = new SupVipDaoImpl();
		String aString = "南京";
		String bString = "新街口";
		ArrayList<SuperVipPO> arrayList = supVipDaoImpl.getStrict(aString, bString);
		System.out.println(arrayList.size());
	}
}
