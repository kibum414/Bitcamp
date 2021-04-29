package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardRepository {

    private static final Logger log =
            LoggerFactory.getLogger(BoardRepository.class);

    @Autowired
    // All SQL operations performed by this class
    // are logged at debug level,
    // using "org.springframework.jdbc.core.JdbcTemplate"
    // as log category.
    //
    // 위 spring 사전에 나온 설명을 보면 알 수 있듯이,
    // 스프링에서 제공하는 SQL 연산들을 수행 할 수 있도록 해주는
    // JDBC 코드용 기본 템플릿을 말한다.
    //
    // 즉, 스프링은 JDBC를 이용하는 DAO에서 사용할 수 있도록
    // 다양한 템플릿과 콜백을 제공하는데
    // JdbcTemplate은 그 중 하나이다.
    private JdbcTemplate jdbcTemplate;

    public List<Board> list() throws Exception {
        log.info("list()");

        // 많은 결과 값(로우 값)을 처리 할 수 있는 메소드이다.
        // List 형식을 활용해 여러 개의 로우 값들을 저장할 수 있다.
        // 첫 번째 파라미터 : 실행할 SQL 쿼리를 넣는다.
        // 두 번째 파라미터 : 바인딩 할 파라미터가 있으면 추가해주자.
        // 세 번째 (마지막) 파라미터 : RowMapper 콜백을 넣어주자.
        //
        // RowMapper에서 만들어진 Board 오브젝트는
        // 템플릿이 미리 준비한 List 컬렉션에 추가되며,
        // 작업을 마치면
        // 모든 로우에 대한 Board 오브젝트를 담고 있는 List 오브젝트가 리턴된다.
        //
        // 쿼리, extractor 한 묶음 (옛날 방식)
        List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, writer, " +
                    "reg_date from board where board_no > 0 " +
                    "order by board_no desc, reg_date desc",

            // RowMapper란?
            // 템플릿으로부터 ResultSet을 전달받고, 필요한 정보를 추출해서 리턴하는 방식으로 동작
            // ResultSet의 Row 하나만을 매핑하기 위해 사용된다.
            // 쿼리 실행 주체 (내부적으로 구동)
            // 여러 개의 데이터들을 돌면서 board로 리턴하여 하나씩 List에 넣음
            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum)
                        throws SQLException {

                    // select로 가져온 것들을 board에 세팅
                    Board board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    // getTimestamp: 날짜와 시간까지 나옴
                    board.setRegDate(rs.getTimestamp("reg_date"));

                    // 데이터를 전부 당겨온 후 results에 넣음
                    return board;
                }
            }
        );

        return results;
    }

    public void create(Board board) throws Exception {
        log.info("create()");

        // ?, ?, ?: title, content, writer를 원하는 값으로 세팅해서 넣을 수 있음
        String query = "insert into board(title, content, writer) " +
                "values(?, ?, ?)";

        // printf 방식과 유사
        // ?, ?, ? 부분에 각 값을 대입하여 업데이트 하는 것
        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getWriter());
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date " +
                    "from board where board_no = ?",

            new RowMapper<Board>() {
                @Override
                public Board mapRow(ResultSet rs, int rowNum)
                        throws SQLException {

                    Board board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setWriter(rs.getString("writer"));
                    // getDate: 날짜만 나옴
                    board.setRegDate(rs.getDate("reg_date"));

                    return board;
                }
            // ? 에 해당하는 부분
            }, boardNo
        );

        // 비어 있으면 null 값,
        // 비어 있지 않으면 첫 번째 값(result 결과 = 선택한 게시판 글 번호)을 반환
        return results.isEmpty() ? null : results.get(0);
    }

    // post로 동작
    public void remove(Integer boardNo) throws Exception {
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    // post로 동작
    public void modify(Board board) throws Exception {
        // 작성자는 갱신을 못 하므로 빠지고
        // 선택한 게시판 번호에 해당하는 제목과 내용을 업데이트 함
        String query = "update board set title = ?, content = ? " +
                "where board_no = ?";

        jdbcTemplate.update(
                query, board.getTitle(),
                board.getContent(), board.getBoardNo()
        );
    }
}
