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
		    ArrayList<Label> labels = (ArrayList<Label>) hibernateUtil.getAll("label",Label.class);
		    ArrayList<Label> labels2 = new ArrayList<Label>();
		    for(Label po:labels){
		    	if(po.getHotelId().equals(hotelid)){
		    		labels2.add(po);
		    	}
		    }
			return labels2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
