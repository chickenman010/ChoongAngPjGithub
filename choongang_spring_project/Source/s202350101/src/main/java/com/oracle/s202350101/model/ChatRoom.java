package com.oracle.s202350101.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Date 
@Getter
@Setter
@ToString
public class ChatRoom {
	private int 	chat_room_id;
	private String 	sender_id;
	private String 	receiver_id;
	
	// 조회용
	private String  user_name;
	
}
