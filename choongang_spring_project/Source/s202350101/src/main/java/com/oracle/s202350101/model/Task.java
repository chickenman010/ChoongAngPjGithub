package com.oracle.s202350101.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Date 
@Getter
@Setter
@ToString
public class Task {
		private int		Task_Id;
		private int		Project_Id;
		private int		Project_Step_Seq;
		private String	User_Id;
		private String	Task_Subject;
		private String	Task_Content;
		private Date	Task_Stat_Time;
		private Date	Task_End_Itme;
		private String	Task_Priority;
		private String	Task_Status;
		private int		Garbage;
		
		
		// 조회용
		private String  user_name;
		private String  project_s_name;
        private int     status_0_count;
        private int 	status_1_count;
        private int 	status_2_count;
        private String 	search;           
        private String 	keyword;
        private String 	pageNum;
        private int 	start;                          
        private int 	end;
        private int 	rn;
}
