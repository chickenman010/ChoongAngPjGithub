package com.oracle.s202350101.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Date 
@Getter
@Setter
@ToString
public class PrjBdRep {
	private int		doc_no;
	private int		project_id;
	private int		app_id;
	private String	user_id;
	private Date	create_date;
	private Date	modify_date;
	private String	subject;
	private String	bd_category;
	private String	doc_body;
	private String	attach_name;
	private String	attach_path;
	
	// 조회용
	private String  app_name;
    private int     start;
    private int     end;
    private String  user_name;          //작성자명
    private String  bd_category_name;   //분류명
    private String  attach_delete_flag; //편집저장시 기존첨부 삭제여부(D)
}
