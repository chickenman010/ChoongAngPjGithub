package com.oracle.s202350101.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.UserInfo;
import com.oracle.s202350101.service.mkhser.MkhService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MkhController {
	
	private final MkhService mkhService;
	
	
//	public String userLoginComfirm() {
//		System.out.println("MkhController userLoginComfirm Start..");
//		
//		
//		return "main";
//	}
	
	/* 로그인 (interCeptor) */
	@RequestMapping(value = "user_login")
	public String userLogin(UserInfo userInfo, Model model) {
		System.out.println("MkhController userLogin Start..");
		System.out.println("userInfo.getUser_id()->"+userInfo.getUser_id());
		System.out.println("userInfo.getUser_pw()->"+userInfo.getUser_pw());
		
		UserInfo userConfirm = mkhService.userLogin(userInfo);
		
		if(userConfirm != null) {
			model.addAttribute("userConfirm", userConfirm);
			return "main";
		} else {
			return "user_login";
		}
		
	}
	// 로그인 인터셉터
	// 2번째 실행
	@PostMapping(value = "interCeptor")
	public String interCeptor(String user_id, String user_pw, Model model) {
		System.out.println("MkhController interCeptor Start..");
		System.out.println("MkhController userLogin id->"+user_id);
		System.out.println("MkhController userLogin id->"+user_pw);
		
		// 존재 : 1, 비존재  : 0
		int userIdCnt = mkhService.userIdCount(user_id);
		int userPwCnt = mkhService.userPwCount(user_pw);
				
		System.out.println("EmpController userLogin userIdCnt->" + userIdCnt);
		System.out.println("EmpController userLogin userPwCnt->" + userPwCnt);
		
		model.addAttribute("user_id", user_id);
		model.addAttribute("userIdCnt", userIdCnt);
		model.addAttribute("userPwCnt", userPwCnt);

		System.out.println("interCeptor End");
		
		return "interCeptor";
	}
	
	/* 회원가입 */
	// 회원가입 동의 페이지로 이동
	@RequestMapping(value = "user_join_agree")
	public String userJoinAgree() {
		System.out.println("MkhController userJoinAgree Start..");
		return "user/user_join_agree";
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "user_join_write")
	public String userJoinWrite(Model model) {
		System.out.println("MkhController userJoinWrite Start..");
		// class_id GET
		List<ClassRoom> classList = mkhService.createdClass();
		System.out.println("MkhController user_join_write classList.size->"+classList.size());
		model.addAttribute("classList", classList);
		
		return "user/user_join_write";
	}
	
//	 회원가입 정보 insert
	@PostMapping(value = "writeUserInfo")
	public String writeUserInfo(UserInfo userInfo, Model model) {
		System.out.println("MkhController writeUserInfo Start...");
	
		int result = mkhService.insertUserInfo(userInfo);
		if(result > 0) return "user/user_login";
		else return "redirect:user_join_write";
	}
	
	
	/* 마이페이지 */
	
	// 마이페이지 수정으로 이동
	@RequestMapping(value = "mypage_main")
	public String mypageMain() {
		System.out.println("MkhController mypageMain Start..");
		return "mypage/mypage_main";
	}
	
	// 개인정보 수정용 비밀번호 확인 페이지
	@RequestMapping(value = "mypage_check_pw")
	public String mypageCheckPw() {
		System.out.println("MkhController mypageCheckPw Start..");
		return "mypage/mypage_check_pw";
	}
	
	// 개인정보 수정 페이지
	@RequestMapping(value = "mypage_update")
	public String mypageUpdate() {
		System.out.println("MkhController mypageUpdate Start..");
		return "mypage/mypage_update";
	}
	
	/* MYPOST */
	
	// 내가 쓴 게시글
	@RequestMapping(value = "mypost_board_list")
	public String mypostBoardList(BdQna bdQna, Model model) {
		System.out.println("MkhController mypostBoardList Start..");
		
		// 나중에 게시판마다 count 다 더해서 보내야 할듯??
		// 내가 쓴 게시글 Count
		// 질문게시판
		int totalBdQna = mkhService.totalQna();
		System.out.println("totalBdQnaCount->"+totalBdQna);
		
		// 공용게시판 Count
//		int totalBdFree = mkhService.totalFree();
//		System.out.println("totalBdQnaCount->"+totalBdFree);
//		
//		// 내가 쓴 게시글 Count
//		int totalBdPrj = mkhService.totalPrj();
//		System.out.println("totalBdQnaCount->"+totalBdPrj);
//		
//		int totalBdQna = mkhService.totalQna();
//		System.out.println("totalBdQnaCount->"+totalBdQna);

		// 내가 쓴 게시글 출력
		List<BdQna> qnaList = mkhService.bdQnaList();
		System.out.println("MkhController mypostBoardList qnaList.size->"+qnaList.size());
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("totalBdQna", totalBdQna);

		
		return "mypost/mypost_board_list";
	}
	
	// 내가 쓴 댓글
	@RequestMapping(value = "mypost_comment_list")
	public String mypostCommentList() {
		System.out.println("MkhController mypostCommentList Start..");
		return "mypost/mypost_comment_list";
	}
	
	// 내가 추천한 게시글
	@RequestMapping(value = "mypost_good_list")
	public String mypostGoodList() {
		System.out.println("MkhController mypostGoodList Start..");
		return "mypost/mypost_good_list";
	}

}
