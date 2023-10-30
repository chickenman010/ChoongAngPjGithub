package com.oracle.s202350101.dao.mkhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.UserInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MkhDaoImpl implements MkhDao {
	
	private final SqlSession session;

	@Override
	public int insertUserInfo(UserInfo userInfo) {
		int result = 0;
		System.out.println("MkhDaoImpl insert Start...");
		try {
			result = session.insert("InsertUserInfo", userInfo);
		} catch (Exception e) {
			System.out.println("MkhDaoImpl insert Exception->" +e.getMessage());
		}
		return result;
	}

	@Override
	public List<ClassRoom> createdClass() {
		List<ClassRoom> classList = null;
		System.out.println("MkhDaoImpl createdClass start...");
		try {
			// ClassRoom의 class_id와 class_room_num만 select
			classList = session.selectList("createdClassSelect");
		} catch (Exception e) {
			System.out.println("MkhDaoImpl createdClass Exception->" +e.getMessage());
		}
		return classList;
	}

	@Override
	public List<BdQna> bdQnaList() {
		List<BdQna> qnaList = null;
		System.out.println("MkhDaoImpl bdQnaList start...");
		try {
			// user_id에 해당하는 게시물, count 출력 sql
			qnaList = session.selectList("userIdQnaListSelect");
		} catch (Exception e) {
			System.out.println("MkhDaoImpl bdQnaList Exception->" +e.getMessage());
		}
		return qnaList;
	}

	@Override
	public int totalQna() {
		int totalBdQna = 0;		
		System.out.println("MkhDaoImpl totalQna start...");
		try {
			totalBdQna = session.selectOne("userIdQnaListCount");
		} catch (Exception e) {
			System.out.println("MkhDaoImpl totalQna Exception->" +e.getMessage());
		}

		return totalBdQna;
	}

	@Override
	public int userIdCount(String user_id) {
		int result = 0;
		System.out.println("Member1DaoImpl id->"+user_id);
		try {
			result = session.selectOne("userIdCount", user_id);
		} catch (Exception e) {
			System.out.println("MkhDaoImpl userIdCount Exception->"+e.getMessage());
		}	
		return result;
	}

	@Override
	public int userPwCount(String user_pw) {
		int result = 0;
		System.out.println("Member1DaoImpl pw->"+user_pw);
		try {
			result = session.selectOne("userPwCount", user_pw);
		} catch (Exception e) {
			System.out.println("MkhDaoImpl userPwCount Exception->"+e.getMessage());
		}	
		return result;
	}

	@Override
	public UserInfo userLogin(UserInfo userInfo) {
		UserInfo userConfirm = null;
		try {
			userConfirm = session.selectOne("userLoginConfirm", userInfo);
		} catch (Exception e) {
			System.out.println("MkhDaoImpl userLogin Exception->"+e.getMessage());
		}
		
		return userConfirm;
	}

}
