package com.example.board.repository.board;

import com.example.board.entity.board.VueBoard;
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

@Repository
public class VueBoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(VueBoard board) throws Exception {
        String query = "insert into board (title, content, writer) values (?, ?, ?)";

        // jdbcTemplate.update()로 레코드를 삽입하는 동시에 해당 레코드의 Key 값(sequence) 반환 받기
        // KeyHolder와 PreparedStatement 사용

        // MySQL의 AUTO_INCREMENT 칼럼을 가진 테이블에 값을 삽입하면 해당 칼럼의 값이 자동으로 생성되므로,
        // INSERT 쿼리에 자동 증가 칼럼에 해당하는 값이 지정되지 않음
        // MySQL에서 AUTO_INCREMENT 컬럼을 지정하여 PK로 활용하는 경우가 있는데,
        // update() 메소드는 변경된 행의 개수만 리턴하므로
        // 자동 생성된 키 값을 알아낼 수 없음
        // KeyHolder를 사용하면 자동 생성되는 컬럼의 값을 가져올 수 있음
        // GeneratedKeyHolder 객체 : KeyHolder 구현 클래스
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
            // Statement와 PreparedStatement
            // 공통점 : 두 인터페이스 모두 SQL 질의문을 전달하는 역할을 한다.
            //        사용 시 반드시 try~catch문 또는 throws 처리를 해야한다.
            // 차이점 : 캐시 사용 유무
            //        Statement와 달리 PreparedStatement는 객체를 캐시에 담아 재사용 하므로
            //        반복적으로 쿼리를 수행한다면 Statement에 비해 성능과 보안성이 좋음
            // PreparedStatement 객체는 Connection 객체의 preparedStatement() 메소드를 사용해서 생성한다.
            // 이 메소드는 인수로 SQL 문을 담은 String 객체가 필요하다.
            // SQL 문장이 미리 컴파일 되고,
            // 실행 시간 동안 인수값을 위한 공간을 확보할 수 있다는 점에서 Statement 객체와 다르다.
            // Statement 객체의 SQL은 실행될 때 매번 서버에서 분석해야 하는 반면,
            // PreparedStatement 객체는 한 번 분석되면 재사용이 용이하다.
            // 각각의 인수에 대해 위치 홀더(placeholder)를 사용하여 SQL 문장을 정의할 수 있게 해준다.
            // 위치 홀더는 ? 로 표현된다.
            // 동일한 SQL 문을 특정 값만 바꾸어서 여러 번 실행해야 할 때,
            // 인수가 많아서 SQL 문을 정리해야 될 필요가 있을 때 사용하면 유용하다.
            new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con)
                        throws SQLException {
                    // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                    // 자동 생성되는 컬럼(자동 증가하는 key 값)을 두 번째 파라미터로 전달
                    // prepareStatement : 미리 인자들을 담는 틀
                    // 미리 틀을 만듦 : ps
                    PreparedStatement ps = con.prepareStatement(query, new String[]{"boardNo"});
                    // parameterIndex: 쿼리문 ?의 순번
                    // 틀에 인자를 넣음 (ps에 내용 추가)
                    ps.setString(1, board.getTitle());
                    ps.setString(2, board.getContent());
                    ps.setString(3, board.getWriter());

                    // 생성한 PreparedStatement 객체 리턴
                    return ps;
                }
            }, keyHolder);

        board.setBoardNo(keyHolder.getKey().longValue());
    }

    public VueBoard read(Long boardNo) throws Exception {
        List<VueBoard> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date " +
                    "from board where board_no = ?",
            // RowMapper를 사용하면 원하는 형태의 결과값을 반환할 수 있음
            // SELECT로 나온 여러 개의 값 반환, 사용자가 원하는 형태로 반환 모두 가능
            new RowMapper<VueBoard>() {
                @Override
                // ResultSet : 반환값을 담는 틀
                // ResultSet에 값을 담아와서 VueBoard 객체에 저장, rowNum만큼 반복
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
            // boardNo: ?에 해당하는 값
            }, boardNo);

        // 게시글이 없으면 널 값, 게시글이 있으면 해당 게시물 정보 리턴
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
        List<VueBoard> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date from board " +
                    "where board_no > 0 order by board_no desc, reg_date desc",
            new RowMapper<VueBoard>() {
                @Override
                public VueBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
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