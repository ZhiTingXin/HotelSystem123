package data.dao.impl;

import java.util.ArrayList;

import PO.Label;
import data.dao.LabelDao;
import other.hibernateUtil;
public class LabelDaoImpl implements LabelDao {

	public boolean addLabel(Label label) {
          try{
        	  hibernateUtil.add(label);
        	  return true;
          }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delLabel(Label label) {
		try {
			hibernateUtil.delete(label);
			return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
	}

	public ArrayList<Label> getLabels(String hotelid) {
		try {
			ArrayList<Label> arrayList = (ArrayList<Label>)hibernateUtil.findbySome("label", "hotelid", hotelid);
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
