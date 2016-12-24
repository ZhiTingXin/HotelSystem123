package other;

public class MyDistricts {

	public final static String[] cities = { "北京", "南京", "上海", "重庆", "郑州", "武汉", "运城", "长沙", "广州", "台北", "香港" };

	final static String[] districtsBJ = { "王府井", "崇文门", "公主坟", "三里屯" };
	final static String[] districtsNJ = { "新街口", "鼓楼", "仙林中心", "应天大街" };
	final static String[] districtsSH = { "徐家汇", "陆家嘴", "南京西路", "淮海路" };
	final static String[] districtsCQ = { "解放碑", "观音桥", "沙坪坝", "杨家坪" };
	final static String[] districtsZZ = { "二七", "花园路", "北环", "碧沙岗" };
	final static String[] districtsWH = { "武广", "江汉路", "武胜路", "菱角湖" };
	final static String[] districtsYC = { "东星", "恒隆国际", "通宝国际", "第壹大道" };
	final static String[] districtsCS = { "五一", "东塘", "溁湾镇", "红星" };
	final static String[] districtsGZ = { "天河", "珠江新城", "东山", "北京路" };
	final static String[] districtsTB = { "西门町", "五分埔", "台北东区", "信义" };
	final static String[] districtsXG = { "中环", "尖沙咀", "旺角", "铜锣湾" };

	public static String[] getDistricts(String city) {

		switch (city) {
		case "北京":
			return districtsBJ;

		case "南京":
			return districtsNJ;

		case "上海":
			return districtsSH;

		case "重庆":
			return districtsCQ;

		case "郑州":
			return districtsZZ;

		case "武汉":
			return districtsWH;

		case "运城":
			return districtsYC;

		case "长沙":
			return districtsCS;

		case "广州":
			return districtsGZ;

		case "台北":
			return districtsTB;

		case "香港":
			return districtsXG;

		default:
			return null;
		}
	}
}
