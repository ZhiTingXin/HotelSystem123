package blservice.impl;

import java.util.ArrayList;

import PO.Label;
import RMI.RemoteHelper;
import VO.LabelVO;
import blservice.Label_blService;
import data.service.LabelDataService;

public class Label_blServiceImpl implements Label_blService {

	LabelDataService labe = RemoteHelper.getInstance().getLabelDataService();

	/**
	 * @param 标签信息
	 * @return 添加标签是否成功
	 */
	public boolean addLabel(LabelVO labelVO) {
		try {
			return labe.addLabel(new Label(labelVO));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 标签信息
	 * @return 删除标签是否成功
	 */
	public boolean delLabel(LabelVO labelVO) {
		try {
			return labe.delLabel(new Label(labelVO));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 酒店id
	 * @return 返回所有酒店标签信息
	 */
	public ArrayList<LabelVO> getHotelLabels(String hotelid) {
		ArrayList<LabelVO> labelVOs = new ArrayList<LabelVO>();
		try {
			ArrayList<Label> labels = labe.getLabels(hotelid);
			for (Label po : labels) {
				labelVOs.add(new LabelVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return labelVOs;
	}

}
