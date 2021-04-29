package com.example.demo.repository.vue;

import com.example.demo.entity.vue.VueBoard;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
현재는 DB 저장 용도로 밖에 못 씀
증권 분석 JSON으로 해서 파이썬으로 해서
데이터 좀 쏴줘 하면 다시 만들어야 함

즉, 정석은 인터페이스로 만들어야 함
 */

@Log
@Repository
public class VueBoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(VueBoard board) throws Exception {
        log.info("VueBoardRepo create()");

        String query = "insert into board(" +
                "title, content, writer) values(?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con)
                            throws SQLException {
                        PreparedStatement ps = con.prepareStatement(query, new String[] {"boardNo"});
                        ps.setString(1, board.getTitle());
                        ps.setString(2, board.getContent());
                        ps.setString(3, board.getWriter());

                        return ps;
                    }
                }, keyHolder);

        board.setBoardNo(keyHolder.getKey().longValue());
    }

    public VueBoard read(Long boardNo) throws Exception {
        log.info("VueBoardRepo read()" + boardNo);

        List<VueBoard> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date " +
                    "from board where board_no = ?",
            new RowMapper<VueBoard>() {
                @Override
                public VueBoard mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    VueBoard board = new VueBoard();

                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    board.setRegDate(rs.getDate("reg_date"));

                    System.out.println("VueBoardRepository: " + board);

                    return board;
                }
            },
        boardNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void update(VueBoard board) throws Exception {
        String query = "update board set title = ?, content = ? " +
                "where board_no = ?";

        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getBoardNo());
    }

    public void delete(Long boardNo) throws Exception {
        String query = "delete from board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public List<VueBoard> list() throws Exception {
        log.info("VueBoardRepo list()");

        List<VueBoard> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date from board " +
                    "where board_no > 0 order by board_no desc, reg_date desc",
            new RowMapper<VueBoard>() {
                @Override
                public VueBoard mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    VueBoard board = new VueBoard();

                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    board.setRegDate(rs.getDate("reg_date"));

                    return board;
                }
            }
        );

        return results;
    }
}
