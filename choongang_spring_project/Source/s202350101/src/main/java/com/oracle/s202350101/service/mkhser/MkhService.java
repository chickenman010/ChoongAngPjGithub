package com.oracle.s202350101.service.mkhser;

import java.util.List;

import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.UserInfo;

public interface MkhService {

	int                insertUserInfo(UserInfo userInfo);
	List<ClassRoom>    createdClass();
	

}
