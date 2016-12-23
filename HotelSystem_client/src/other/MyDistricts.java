package other;

public class MyDistricts {

	public final static String[] cities = { "����", "�Ͼ�", "�Ϻ�", "����", "֣��", "�人", "�˳�", "��ɳ", "����", "̨��", "���" };

	final  String[] districtsBJ = { "������", "������", "������", "������" };
	final static String[] districtsNJ = { "�½ֿ�", "��¥", "����", "Ӧ����" };
	final static String[] districtsSH = { "��һ�", "½����", "�Ͼ���·", "����·" };
	final static String[] districtsCQ = { "��ű�", "������", "ɳƺ��", "���ƺ" };
	final static String[] districtsZZ = { "����", "��԰·", "����", "��ɳ��" };
	final static String[] districtsWH = { "���", "����·", "��ʤ·", "��Ǻ�" };
	final static String[] districtsYC = { "����", "��¡����", "ͨ������", "��Ҽ���" };
	final static String[] districtsCS = { "��һ", "����", "������", "����" };
	final static String[] districtsGZ = { "���", "�齭�³�", "��ɽ", "����·" };
	final static String[] districtsTB = { "�����", "�����", "̨������", "����" };
	final static String[] districtsXG = { "�л�", "��ɳ��", "����", "ͭ����" };

	public String[] getDistricts(String city) {

		switch (city) {
		case "����":
			return districtsBJ;
			
		case "�Ͼ�":
			return districtsNJ;
			
		case "�Ϻ�":
			return districtsSH;
			
		case "����":
			return districtsCQ;
			
		case "֣��":
			return districtsZZ;
			
		case "�人":
			return districtsWH;
			
		case "�˳�":
			return districtsYC;
			
		case "��ɳ":
			return districtsCS;
			
		case "����":
			return districtsGZ;
			
		case "̨��":
			return districtsTB;
			
		case "���":
			return districtsXG;
			
		default:
			return null;
		}
	}
}
