package com.example.demo.bbs.domain;

import javax.persistence.*;

@Entity
@Table(name = "boards")
public class Board {

	@Id
	@GeneratedValue
	@Column(name = "board_no")
	private long boardNo;
	
	@Column(name = "board_name")
	private String boardName;
	
	@Column(name = "content")
	private String content;
}
