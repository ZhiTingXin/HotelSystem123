package data.dao;

import java.util.ArrayList;

import PO.LogofUserPO;

public interface LogOfUserDao {

	public boolean add(LogofUserPO po);

	public ArrayList<LogofUserPO> getLogsOfUser(String userid);
	
}
