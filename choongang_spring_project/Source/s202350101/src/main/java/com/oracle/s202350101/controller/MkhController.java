package com.oracle.s202350101.controller;

import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.s202350101.model.BdFree;
import com.oracle.s202350101.model.BdQna;
import com.oracle.s202350101.model.ClassRoom;
import com.oracle.s202350101.model.PrjBdData;
import com.oracle.s202350101.model.PrjBdRep;
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
	
	// SMTP(Send Mail Transport protocol) 메일 전송 객체
	private final JavaMailSender mailSender;
	
	/* 로그인  */
	// 로그인 화면
	@RequestMapping(value = "user_login")
	public String userLogin(Model model) {
		System.out.println("MkhController userLogin Start..");
	
		return "user/user_login";
	}
	
	// 로그인 인터셉터 체크
	// 2번째 실행
	@PostMapping(value = "user_login_check")
	public String interCeptor(@ModelAttribute("userInfo") @Valid UserInfo userInfo
							 , BindingResult result		  , Model model
							 , HttpServletRequest request , HttpSession session
							  ) {
		System.out.println("MkhController userLoginCheck Start..");
		System.out.println("MkhController userLoginCheck userInfo.getUser_id()->"+userInfo.getUser_id());
		System.out.println("MkhController userLoginCheck userInfo.getUser_pw()->"+userInfo.getUser_pw());
		
		// Validation 오류시 결과
		if(result.hasErrors()) {
			System.out.println("MkhController user_login_check hasErrors...");
			// 오류 메세지를 띄어주기 위해 forward
			return "forward:user_login";
		}
		
		// Login 검증
		UserInfo userInfoDTO = mkhService.userLoginCheck(userInfo);
		
		if(userInfoDTO != null) {	// userInfo가 있으면 main으로 가라
			System.out.println("user_login_check userInfo exists");
			// 검증된 userInfo를 세션에 담음
			session.setAttribute("userInfo", userInfoDTO);
			System.out.println("session.getAttribute(userInfo)->"+session.getAttribute("userInfoDto"));
			return "redirect:/main";
		} else {
			System.out.println("user_login_check userInfois not exist");
			return "redirect:/user_login";	// userInfo가 없으면 user_login으로 가라
		}
	}
	// 로그아웃
	@RequestMapping(value = "user_logout")
	public String userLogout(HttpSession session) {
		// 세션 정보 삭제
		session.invalidate();
		return "redirect:/user_login";
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
		// classroom 모든 정보 가져옴
		List<ClassRoom> classList = mkhService.createdClass();
		System.out.println("MkhController user_join_write classList.size->"+classList.size());
		model.addAttribute("classList", classList);
		
		return "user/user_join_write";
	}
	
	// 중복확인 (PK를 주고 모든 정보 SELECT)
	@GetMapping(value = "id_confirm")
	public String confirm(String user_id, Model model) {
		// ID을 주면 dto를 돌려주는 메소드
		System.out.println("userId->"+user_id);
		UserInfo userInfo = mkhService.confirm(user_id);
		// 입력한 사번을 중복 확인하고 view로 보내주기 위해 model 사용
		model.addAttribute("userInfo", userInfo);
		if (userInfo != null) {
			System.out.println("중복된 ID..");
			model.addAttribute("msg", "중복된 ID 입니다");
			return "forward:user_join_write";
		} else {
			System.out.println("MkhController confirm 사용 가능한 사번..");
			model.addAttribute("msg", "사용 가능한 ID 입니다");
			return "forward:user_join_write";
		}
	}
	
	// 이메일 값 가져옴 + 이메일 전송
	@ResponseBody
	@PostMapping(value = "send_save_mail")
	public String mailCheck(Model model, String auth_email) {
		System.out.println("MkhController mailCheck Start..");
		
		String toMail = auth_email;
		System.out.println("auth_email->"+toMail);
		String setfrom = "cristalmoon112@gmail.com";
		String title = "[ChoongAng] 인증번호 입니다";
		try {
			MimeMessage message = mailSender.createMimeMessage();
															// true는 멀티파트 메세지를 사용하겠다는 의미
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(toMail);
			messageHelper.setSubject(title); // 생략 가능
			String authNumber = (int) (Math.random() * 999999) + 1 + "";
			messageHelper.setText("이메일 인증번호 입니다: " + authNumber);
			System.out.println("이메일 인증번호 입니다: " + authNumber);
			
			// 첨부파일 보내기 위한 로직
//			DataSource dataSource = new FileDataSource("c:\\\\log\\\\hwa.png");
//			messageHelper.addAttachment(MimeUtility.encodeText("ReName.png", "UTF-8", "B"), dataSource);
			mailSender.send(message);
			model.addAttribute("check", 1);  // 정상 전달
			
			return authNumber;	// 인증번호 돌려줌
			
		} catch (Exception e) {
			System.out.println("mailTransport e.getMessage()->"+e.getMessage());
			model.addAttribute("check", 2);  // 전달 실패
		}
		
		return "redirect:user_join_write";
	}
	
	// 회원가입 정보 insert
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
	public String mypageMain(HttpServletRequest request) {
		System.out.println("MkhController mypageMain Start..");
		System.out.println("session.userInfo->"+request.getSession().getAttribute("userInfo"));

		return "mypage/mypage_main";
	}
	
	// 개인정보 수정용 비밀번호 확인 페이지
	@RequestMapping(value = "mypage_check_pw")
	public String mypageCheckPw(HttpServletRequest request) {
		System.out.println("MkhController mypageCheckPw Start..");
		System.out.println("session.userInfo->"+request.getSession().getAttribute("userInfo"));

		return "mypage/mypage_check_pw";
	}
	
	// 개인정보 수정 페이지로 이동
	@RequestMapping(value = "mypage_update")
	public String mypage_update_view(HttpServletRequest request, Model model, String redirectURL) {
		System.out.println("2.MkhController mypage_update_view Start..");
		System.out.println("session.userInfo->"+request.getSession().getAttribute("userInfo"));
		
		// URI 꺼내옴
		String requestURI = (String) request.getSession().getAttribute("requestURI");
		System.out.println("requestURI->"+requestURI);
		
		UserInfo userInfoDTO = (UserInfo) request.getSession().getAttribute("userInfo");
		System.out.println("userInfoDTO.getUser_id()->"+userInfoDTO.getUser_id());
		
		return "mypage/mypage_update";
	}
	
	/* MYPOST - 내가 글 모음*/
	@RequestMapping(value = "mypost_board_list")
	public String mypostBoardList(HttpServletRequest request,  BdQna bdQna, 
								  			UserInfo userInfo, Model model) {
		System.out.println("MkhController mypostBoardList Start..");
	    System.out.println("session.userInfo->"+request.getSession().getAttribute("userInfo"));
	    // userInfo 세션값 받아와서 userInfoDTO로 사용
	    UserInfo userInfoDTO = (UserInfo) request.getSession().getAttribute("userInfo");
	    System.out.println("userinfo.getUser_id()->"+userInfoDTO.getUser_id());

		/* 내가 쓴 게시글  Count */
	    
		// 전체 게시판 Count
		int totalBDCount = mkhService.totalBDcount(userInfoDTO);
		System.out.println("totalBdCount->"+totalBDCount);
		model.addAttribute("totalBDCount", totalBDCount);
		
		// Q&A게시판 Count
		int totalBdQna = mkhService.totalQna(userInfoDTO);
		System.out.println("totalBdQnaCount->"+totalBdQna);
		model.addAttribute("totalBdQna", totalBdQna);
		
		// 공용게시판 Count
		int totalBdFree = mkhService.totalFree(userInfoDTO);
		System.out.println("totalFreeCount->"+totalBdFree);
		model.addAttribute("totalBdFree", totalBdFree);
		
		// 프로젝트 & 공지자료 게시판 Count
		int totalDtPrj = mkhService.totalDtPj(userInfoDTO);
		System.out.println("totalDtPjCount->"+totalDtPrj);
		model.addAttribute("totalDtPrj", totalDtPrj);
		
		// 업무보고 게시판 Count
		int totalRepPrj = mkhService.totalRepPj(userInfoDTO);
		System.out.println("totalRepPjCount->"+totalRepPrj);
		model.addAttribute("totalRepPrj", totalRepPrj);
		
		/* 내가 쓴 게시글 List */
		
		// Q&A 게시판
		List<BdQna> qnaList = mkhService.bdQnaList(userInfoDTO);
		System.out.println("MkhController mypostBoardList qnaList.size->"+qnaList.size());
		model.addAttribute("qnaList", qnaList);
		// 공용 게시판
		List<BdFree> freeList = mkhService.bdFreeList(userInfoDTO);
		System.out.println("MkhController mypostBoardList freeList.size->"+freeList.size());
		model.addAttribute("freeList", freeList);
		// 프로젝트 & 공지자료 게시판
		List<PrjBdData> dataPrjList = mkhService.prjDataList(userInfoDTO);
		System.out.println("MkhController mypostBoardList prjList.size->"+dataPrjList.size());
		model.addAttribute("dataPrjList", dataPrjList);
		// 업무보고 게시판
		List<PrjBdRep> RepPrjList = mkhService.prjRepList(userInfoDTO);
		System.out.println("MkhController mypostBoardList RepPrjList.size->"+RepPrjList.size());
		model.addAttribute("RepPrjList", RepPrjList);
		
		/* 내가 추천한 게시글 출력 --> 빨리 해 !!!!!!!!!!!!!!!!!!!!!ㅠ */
		
		/* 내가 쓴 댓글 출력 */

		
		return "mypost/mypost_board_list";
	}
	
	// 내가 쓴 댓글
	@RequestMapping(value = "mypost_comment_list")
	public String mypostCommentList(HttpServletRequest request) {
		System.out.println("MkhController mypostCommentList Start..");
		// userInfo 세션값 받아와서 userInfoDTO로 사용
	    UserInfo userInfoDTO = (UserInfo) request.getSession().getAttribute("userInfo");
	    
		return "mypost/mypost_comment_list";
	}
	
	// 내가 추천한 게시글
	@RequestMapping(value = "mypost_good_list")
	public String mypostGoodList(HttpServletRequest request) {
		System.out.println("MkhController mypostGoodList Start..");
		// userInfo 세션값 받아와서 userInfoDTO로 사용
	    UserInfo userInfoDTO = (UserInfo) request.getSession().getAttribute("userInfo");
	    
		return "mypost/mypost_good_list";
	}
	
	// 아이디 찾기
	@RequestMapping(value = "user_find_id")
	public String userFindId() {
		System.out.println("MkhController userFindId Start..");
		
		return "user/user_find_id";
	}
	
	// 아이디 찾기 결과
	@RequestMapping(value = "user_find_id_result")
	public String userFindIdResult() {
		System.out.println("MkhController userFindIdResult Start..");
		
		return "user/user_find_id_result";
	}
	
	// 비밀번호 찾기
	@RequestMapping(value = "user_find_pw")
	public String userFindPw() {
		System.out.println("MkhController userFindPw Start..");
		
		return "user/user_find_pw";
	}
	
	// 비밀번호 찾기 인증
	@ResponseBody
	@RequestMapping(value = "user_find_pw_auth")
	public String userFindPwAuth(String user_id, String auth_email, Model model) {
		System.out.println("MkhController userFindPwAuth Start..");
		
		System.out.println("userId->"+user_id);
		System.out.println("auth_email->"+auth_email);
		
		UserInfo userInfo = mkhService.confirm(user_id);
//		System.out.println("userInfo.getUser_email()->"+userInfo.getUser_email());

		// 입력한 ID가 가입할 때 E-mail과 맞는지 확인		
		if (userInfo != null) {
			System.out.println("ID 존재");
			if(auth_email.equals(userInfo.getUser_email())) {
				System.out.println("이메일 주소가 같음");
				return "1";
			} else {
				System.out.println("이메일 주소 다름");
				return "0";
			}
		} else {
			System.out.println("아이디가 존재X");
			return "2";
		}

	}
	
	// 새로운 비밀번호 만들기 페이지
	@RequestMapping(value = "user_find_pw_new")
	public String userFindPwNew() {
		System.out.println("MkhController userFindPwNew Start..");
		
		return "user/user_find_pw_new";
	}
	
	// 비밀번호 업데이트
	@ResponseBody
	@RequestMapping(value = "user_find_pw_update")
	public int userFindPwUpdate(UserInfo userInfo, String user_pw) {
		System.out.println("MkhController userFindPwNewUpdate Start..");
		System.out.println("changing PW ->"+user_pw);
		
		int result = mkhService.updatePw(userInfo);
		
		
		return result;
	}
	

}
