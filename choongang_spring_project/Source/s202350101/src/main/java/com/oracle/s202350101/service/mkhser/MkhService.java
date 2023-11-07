package com.oracle.s202350101.service.mkhser;

import java.util.List;
import java.util.Map;

import com.oracle.s202350101.model.BdFree;
import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.PrjBdData;
import com.oracle.s202350101.model.PrjBdRep;
import com.oracle.s202350101.model.UserEnv;
import com.oracle.s202350101.model.UserInfo;

public interface MkhService {

	int                insertUserInfo(UserInfo userInfo);
	List<ClassRoom>    createdClass();
	UserInfo           userLoginCheck(UserInfo userInfo);
	List<BdQna>        bdQnaList(UserInfo userInfo);
	List<BdFree> 	   bdFreeList(UserInfo userInfo);
	List<PrjBdData>    prjDataList(UserInfo userInfo);
	List<PrjBdRep>     prjRepList(UserInfo userInfo);
	UserInfo           confirm(String user_id);
	int                totalBDcount(UserInfo userInfo);
	int 			   totalQna(UserInfo userInfo);
	int 			   totalFree(UserInfo userInfo);
	int 			   totalDtPj(UserInfo userInfo);
	int 			   totalRepPj(UserInfo userInfo);
//	int                updatePw(String user_id, String user_pw);
	int 			   updatePw(Map<String, String> map);
	UserInfo           userFindId(UserInfo userInfo);
	UserEnv            selectEnv(String user_id);
	ClassRoom          selectClass(String user_id);

}
