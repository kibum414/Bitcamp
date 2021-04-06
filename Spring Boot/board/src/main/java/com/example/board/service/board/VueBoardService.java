package com.example.board.service.board;

import com.example.board.entity.board.VueBoard;

import java.util.List;

public interface VueBoardService {
    // 등록 : 게시물을 등록하는 것이므로 리턴이 필요 없는 void, 인자는 VueBoard 형식
    public void register(VueBoard board) throws Exception;
    // 읽기 : 게시물 번호로 게시물을 불러오는 것이므로 리턴 형식은 VueBoard, 인자는 boardNo
    public VueBoard read(Long boardNo) throws Exception;
    // 수정 : 게시물을 수정하고 반영하는 것이므로 리턴이 필요 없는 void, 인자는 VueBoard 형식
    public void modify(VueBoard board) throws Exception;
    // 삭제 : 게시물 번호로 게시물을 불러와 삭제하는 것이므로 리턴이 필요 없는 void, 인자는 boardNo
    public void remove(Long boardNo) throws Exception;
    // 게시판 : 게시물 리스트를 전부 보여주어야 하므로 리턴 형식은 List<VueBoard>, 인자 필요 없음
    public List<VueBoard> list() throws Exception;
}
