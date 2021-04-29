package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;

    @Override
    public List<Board> list() throws Exception {
        return boardRepo.list();
    }

    @Override
    public void register(Board board) throws Exception {
        boardRepo.create(board);
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        // Entity(엔티티)로 Board를 받으므로 Attribute(속성)로 board를 받음
        return boardRepo.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepo.remove(boardNo);
    }

    @Override
    // 실제 DB를 받아와서 수정하고 저장하는 것이므로 Board 전체를 받아 옴
    public void modify(Board board) throws Exception {
        boardRepo.modify(board);
    }
}
