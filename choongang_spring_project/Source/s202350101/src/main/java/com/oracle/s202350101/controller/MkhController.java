package com.oracle.s202350101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s202350101.service.mkhser.MkhService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
// @RequiredArgsConstructor
public class MkhController {
	
//	private final MkhService mkhService;
	
	/* 회원가입 */
	
	// 회원가입 동의 페이지로 이동
	@RequestMapping(value = "user_join_agree")
	public String userJoinAgree() {
		System.out.println("MkhController userJoinAgree Start..");
		return "user/user_join_agree";
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "user_join_write")
	public String userJoinWrite() {
		System.out.println("MkhController userJoinWrite Start..");
		return "user/user_join_write";
	}
	
	
	/* 마이페이지 */
	
	// 마이페이지 수정으로 이동
	@RequestMapping(value = "mypage_main")
	public String mypageRead() {
		System.out.println("MkhController mypageRead Start..");
		return "mypage/mypage_read";
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
	public String mypostBoardList() {
		System.out.println("MkhController mypostBoardList Start..");
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
