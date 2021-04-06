package com.example.board.entity.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 코드가 컴파일 될 때, Getter/Setter 메소드를 생성
@Getter
@Setter
// VueBoard 변수 값들 리턴해주는 toString() 메소드를 생성
// @ToString(exclude={"제외할 값"}) 처럼 원하지 않는 속성은 제외 가능
@ToString
public class VueBoard {
    private long boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
