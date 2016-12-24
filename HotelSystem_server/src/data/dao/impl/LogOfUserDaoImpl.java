package data.dao.impl;

import java.util.ArrayList;

import PO.LogofUserPO;
import data.dao.LogOfUserDao;
import other.hibernateUtil;

public class LogOfUserDaoImpl implements LogOfUserDao {

	public boolean add(LogofUserPO po) {
		hibernateUtil.add(po);
		return true;
	}

	public ArrayList<LogofUserPO> getLogsOfUser(String userid) {
		ArrayList<LogofUserPO> list = new ArrayList<LogofUserPO>();
		ArrayList<LogofUserPO> logofUserPOs = (ArrayList<LogofUserPO>)hibernateUtil.getAll("userLog", LogofUserPO.class);
		for(LogofUserPO po:logofUserPOs){
			if(po.getUserid().equals(userid)){
				list.add(po);
			}
		}
		return list;
	}

}
