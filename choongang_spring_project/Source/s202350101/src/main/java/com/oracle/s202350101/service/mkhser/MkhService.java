package com.oracle.s202350101.service.mkhser;

import java.util.List;

import com.oracle.s202350101.model.BdFree;
import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.PrjBdData;
import com.oracle.s202350101.model.PrjBdRep;
import com.oracle.s202350101.model.UserInfo;

public interface MkhService {

	int                insertUserInfo(UserInfo userInfo);
	List<ClassRoom>    createdClass();
	int                totalQna(UserInfo userinfo);
	int                userIdCount(String user_id);
	int                userPwCount(String user_pw);
	UserInfo           userLoginCheck(UserInfo userInfo);
	List<BdQna>        bdQnaList(UserInfo userinfo);
//	List<BdFree> 	   bdFreeList();
//	List<PrjBdData>    PrjDataList();
//	List<PrjBdRep>     PrjRepList();
//	

}
