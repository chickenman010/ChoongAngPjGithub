# 🐶 PMS(Project Management System) 사이트 제작
- 프로젝트 수행에 필요한 작업들을 체계적으로 관리할 수 있도록 편의를 제공하는 시스템
- 프로젝트 진행 단계별 작업 관리 및 자료 공유의 편의와 효율적인 프로젝트 산출물 관리
- 원활한 자료 공유 및 실시간 의사소통 지원

## ⏰ 개발기간
- 기간 : 2023-10-16 ~ 2023-11-30

## 🧑‍🤝‍🧑 개발인원
### 총 7명
- 황인정 팀장 : 
  - 역할 : 프로젝트 일정 관리, 발표
  - 담당 파트 : 프로젝트 생성, 프로젝트 관리, 관리자 페이지, 통합검색 
- 이진희 팀원 : 프로젝트용 캘린더, 알림, 회의록 게시판
- 이광현 팀원 : 프로젝트 작업 문서, 휴지통, 팀원별 진척률
- 조미혜 팀원 : 메인화면, 프로젝트 게시판
- 강준우 팀원 : 채팅, 관리자 페이지
- 문경훈 팀원 : 회원가입, 로그인 및 로그아웃, 아이디 및 비밀번호 찾기, 회원관리
- 차예지 팀원 : 공지사항, 이벤트, 자유 게시판, To-Do List

## ⚙️ 개발환경
- Spring Framework : Spring Boot 2.7.17 Version
- Java : 11
- JDK : 11.0.12
- Tomcat : 9.0 Version
- DB : Oracle Database 11g Express
- ojbdc : 8 version
- ORM : MyBatis
- 개발언어 : Java, JavaScript, Html, Css
- 라이브러리 : JQuery, Lombok, Jstl, JavaMail

## 🛠️ ERD
![image](https://github.com/chickenman010/ChoongAngPjGithub/assets/144098667/c1efeae8-cf77-425c-bfc8-730e587d9f92)

## 🎚️ 업무 프로세스
![image](https://github.com/chickenman010/ChoongAngPjGithub/assets/144098667/5b58244b-914c-4188-afdc-a4fd077ad146)

## ✔️주요기능
- 회원관리
  - 회원가입
    - 개요 : 서비스 이용을 위한 사용자 인증 가능하도록 사용자 정보 등록
  - 로그인/로그아웃
    - 개요 : 로그인 : 서비스 이용을 위한 사용자 인증 및 인가 / 로그아웃 : 사용자 인증 무효화
    - 주요 기술 : Session을 통해 로그인, 로그아웃
  - ID/PW 찾기
    - 개요 : 본인이 입력한 정보를 바탕으로 ID 찾기 및 임시 비밀번호 발급
    - 주요 기술 : Java Mail를 사용하여 메일인증
  - 회원정보 변경
    - 개요 : 본인의 상세 정보를 조회 및 수정
  - 페이지 접근 제한
    - 주요 기술 : InterCeptor를 활용하여 페이지 접근 제한 구현

- 알림
  - 권한 알림
    - 개요 : 각 권한 계정 접속 시 당일 회의 일정, 답글, 댓글 알림, 프로젝트 생성 승인 알림 등 제공
    - 주요 기술 : WebSocket과 Stomp를 활용하여 구현

- 프로젝트
  - 프로젝트 생성
    - 개요 : 프로젝트 시작 전 정보 및 소개 생성페이지(팀장만 접근가능)
  - 프로젝트 단계 프로파일
    - 개요 : 프로젝트 정보 및 단계별 상세 내용 기입
  - 프로젝트 Home
    - 개요 : 프로젝트의 전체 현황(프로젝트 정보, 팀원별 작업 진척률 등)을 한눈에 파악
  - 작업보드 / 타임라인
    - 개요 : 작업의 상태와 합계를 가져와 그래프로 시각
  - 회의록
    - 개요 : 프로젝트 기간 및 회의 일정 확인 가능한 캘린더 기능 제공
  - 프로젝트 공지/자료
    - 개요 : 프로젝트 팀 내에서 공지를 게시하고 팀원들간 공유할 자료를 자유롭게 등록/조회
  - 프로젝트 업무보고
    - 개요 : 프로젝트 수행 시 팀원들의 일일보고 또는 주간보고를 등록하고 팀장과 댓글로 소통

- 관리자 설정
  - 팀장 권한 설정
    - 개요 : 프로젝트 팀장 권한을 설정
  - 게시판 관리
  - 프로젝트 관리
    - 개요 : 프로젝트 생성 승인




