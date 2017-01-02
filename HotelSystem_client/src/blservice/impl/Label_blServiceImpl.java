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
	 * @param ��ǩ��Ϣ
	 * @return ��ӱ�ǩ�Ƿ�ɹ�
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
	 * @param ��ǩ��Ϣ
	 * @return ɾ����ǩ�Ƿ�ɹ�
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
	 * @param �Ƶ�id
	 * @return �������оƵ��ǩ��Ϣ
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
