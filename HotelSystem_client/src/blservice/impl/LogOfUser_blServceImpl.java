package blservice.impl;

import java.util.ArrayList;

import PO.LogofUserPO;
import RMI.RemoteHelper;
import VO.LogofUserVO;
import blservice.LogOfUser_blServce;

public class LogOfUser_blServceImpl implements LogOfUser_blServce {

	public boolean addLogOfUser(LogofUserVO vo) {
		try {
			RemoteHelper.getInstance().getLogOfUserDataService().add(new LogofUserPO(vo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<LogofUserVO> getAllLogsOfUser(String userID) {
		ArrayList<LogofUserVO> logs = new ArrayList<LogofUserVO>();
		try {
			ArrayList<LogofUserPO> logofUserPOs = RemoteHelper.getInstance().getLogOfUserDataService()
					.getAllLogsOfUser(userID);
			for (LogofUserPO po : logofUserPOs) {
				logs.add(new LogofUserVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logs;
	}

}
