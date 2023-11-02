package com.oracle.s202350101.dao.mkhDao;

import java.util.List;

import com.oracle.s202350101.model.BdFree;
import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.PrjBdData;
import com.oracle.s202350101.model.PrjBdRep;
import com.oracle.s202350101.model.UserInfo;

public interface MkhDao {

	int             insertUserInfo(UserInfo userInfo);
	List<ClassRoom> createdClass();
	int             totalQna(UserInfo userInfo);
	UserInfo        userLoginCheck(UserInfo userInfo);
	List<BdFree>    bdFreeList(UserInfo userInfo);
	List<PrjBdData> prjDataList(UserInfo userInfo);
	List<PrjBdRep>  prjRepList(UserInfo userInfo);
	List<BdQna>     bdQnaList(UserInfo userInfo);
	UserInfo        confirm(String user_id);

}
