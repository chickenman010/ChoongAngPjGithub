package com.oracle.s202350101.service.mkhser;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.s202350101.dao.mkhDao.MkhDao;
import com.oracle.s202350101.model.BdFree;
import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.PrjBdData;
import com.oracle.s202350101.model.PrjBdRep;
import com.oracle.s202350101.model.UserInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MkhServiceImpl implements MkhService {
	
	private final MkhDao	mkhdao;

	@Override
	public int insertUserInfo(UserInfo userInfo) {
		int result = 0;
		System.out.println("MkhServiceImpl insert Start...");
		result = mkhdao.insertUserInfo(userInfo);
		return result;
	}

	@Override
	public List<ClassRoom> createdClass() {
		List<ClassRoom> classList = null;
		System.out.println("MkhServiceImpl createdClass Start...");
		classList = mkhdao.createdClass();
		System.out.println("MkhServiceImpl classList.size()->" +classList.size());
		
		return classList;
	}

	@Override
	public List<BdQna> bdQnaList(UserInfo userinfo) {
		List<BdQna> qnaList = null;
		System.out.println("MkhServiceImpl bdQnaList Start...");
		qnaList = mkhdao.bdQnaList(userinfo);
		System.out.println("MkhServiceImpl qnaList.size()->" +qnaList.size());
		
		return qnaList;
	}

	@Override
	public int totalQna(UserInfo userinfo) {
		System.out.println("MkhServiceImpl totalQna Start...");
		int totalBdQna = mkhdao.totalQna(userinfo);

		return totalBdQna;
	}

	@Override
	public int userIdCount(String user_id) {
		System.out.println("MkhServiceImpl userIdCount id ->"+user_id);
		return mkhdao.userIdCount(user_id);
	}

	@Override
	public int userPwCount(String user_pw) {
		System.out.println("MkhServiceImpl userPwCount pw ->"+user_pw);
		return mkhdao.userPwCount(user_pw);
	}

	@Override
	public UserInfo userLoginCheck(UserInfo userInfoDTO) {
		System.out.println("MkhServiceImpl userLoginCheck Start..");
		UserInfo userInfo = mkhdao.userLoginCheck(userInfoDTO);

		return userInfo;
	}

//	@Override
//	public List<BdFree> bdFreeList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<PrjBdData> PrjDataList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<PrjBdRep> PrjRepList() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
