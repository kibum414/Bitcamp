package com.example.demo.bbs.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="boards")
public class Board {
	@Id
	@GeneratedValue
	@Column(name="board_no")
	private Long boardNo;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="writer")
	private String writer;
	
	@Column(name="reg_date")
	private Date regDate;
}