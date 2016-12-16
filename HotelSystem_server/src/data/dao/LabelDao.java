package data.dao;

import java.util.ArrayList;

import PO.Label;

public interface LabelDao {

	public boolean addLabel(Label label);
	
	public boolean delLabel(Label label);
	
	public ArrayList<Label> getLabels(String hotelid);
}
