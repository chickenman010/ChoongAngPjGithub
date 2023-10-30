package com.oracle.s202350101.dao.mkhDao;

import java.util.List;

import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.UserInfo;

public interface MkhDao {

	int             insertUserInfo(UserInfo userInfo);
	List<ClassRoom> createdClass();
	List<BdQna>     bdQnaList();
	int             totalQna();
	int             userIdCount(String user_id);
	int             userPwCount(String user_pw);
	UserInfo        userLoginCheck(UserInfo userInfo);

}
