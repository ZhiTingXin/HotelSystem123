package blservice;

import java.util.ArrayList;

import VO.LogofUserVO;

public interface LogOfUser_blServce {

	public boolean addLogOfUser(LogofUserVO vo);
	
	public ArrayList<LogofUserVO> getAllLogsOfUser(String userID);
}
