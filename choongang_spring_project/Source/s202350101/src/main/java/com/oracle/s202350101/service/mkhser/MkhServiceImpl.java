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
	public int totalBDcount(UserInfo userInfo) {
		System.out.println("MkhServiceImpl totalBDcount Start...");
		int totalBDCount = mkhdao.totalBDcount(userInfo);

		return totalBDCount;
	}

	@Override
	public UserInfo userLoginCheck(UserInfo userInfoDTO) {
		System.out.println("MkhServiceImpl userLoginCheck Start..");
		UserInfo userInfo = mkhdao.userLoginCheck(userInfoDTO);

		return userInfo;
	}
	
	@Override
	public List<BdQna> bdQnaList(UserInfo userInfo) {
		List<BdQna> qnaList = null;
		System.out.println("MkhServiceImpl bdQnaList Start...");
		qnaList = mkhdao.bdQnaList(userInfo);
		System.out.println("MkhServiceImpl qnaList.size()->" +qnaList.size());
		
		return qnaList;
	}
	
	@Override
	public List<BdFree> bdFreeList(UserInfo userInfo) {
		List<BdFree> freeList = null;
		System.out.println("MkhServiceImpl bdFreeList Start...");
		freeList = mkhdao.bdFreeList(userInfo);
		System.out.println("MkhServiceImpl freeList.size()->" +freeList.size());
		
		return freeList;
	}

	@Override
	public List<PrjBdData> prjDataList(UserInfo userInfo) {
		List<PrjBdData> dataPrjList = null;
		System.out.println("MkhServiceImpl PrjDataList Start...");
		dataPrjList = mkhdao.prjDataList(userInfo);
		System.out.println("MkhServiceImpl dataPrjList.size()->" +dataPrjList.size());
		
		return dataPrjList;
	}

	@Override
	public List<PrjBdRep> prjRepList(UserInfo userInfo) {
		List<PrjBdRep> RepPrjList = null;
		System.out.println("MkhServiceImpl PrjRepList Start...");
		RepPrjList = mkhdao.prjRepList(userInfo);
		System.out.println("MkhServiceImpl RepPrjList.size()->" +RepPrjList.size());
		
		return RepPrjList;
	}

	@Override
	public UserInfo confirm(String user_id) {
		System.out.println("MkhServiceImpl confirm Start...");
		UserInfo userInfo = mkhdao.confirm(user_id);
		
		return userInfo;
	}

	@Override
	public int totalQna(UserInfo userInfo) {
		System.out.println("MkhServiceImpl totalQna Start...");
		int totalBdQna = mkhdao.totalQna(userInfo);

		return totalBdQna;
	}

	@Override
	public int totalFree(UserInfo userInfo) {
		System.out.println("MkhServiceImpl totalFree Start...");
		int totalBdFree = mkhdao.totalFree(userInfo);

		return totalBdFree;
	}

	@Override
	public int totalDtPj(UserInfo userInfo) {
		System.out.println("MkhServiceImpl totalDtPj Start...");
		int totalDtPrj = mkhdao.totalDtPj(userInfo);

		return totalDtPrj;
	}

	@Override
	public int totalRepPj(UserInfo userInfo) {
		System.out.println("MkhServiceImpl totalRepPj Start...");
		int totalRepPrj = mkhdao.totalRepPj(userInfo);

		return totalRepPrj;
	}

}
