package com.oracle.s202350101.dao.mkhDao;

import java.util.List;

import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.UserInfo;

public interface MkhDao {

	int             insertUserInfo(UserInfo userInfo);
	List<ClassRoom> createdClass();

}
