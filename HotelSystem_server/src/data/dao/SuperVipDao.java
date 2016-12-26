package data.dao;

import java.util.ArrayList;

import PO.SuperVipPO;

public interface SuperVipDao {

	public boolean addSupVip(SuperVipPO po);
	
	public boolean modifySupVip(SuperVipPO po);
	
	public boolean delSupVip(SuperVipPO po);
	
    public int getSuperNum();
    
	public ArrayList<SuperVipPO> getStrict(String city,String disstrict);
}
