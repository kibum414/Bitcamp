package pkb.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;
import pkb.board.domain.Board;

@Log4j
@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private HikariDataSource dataSource;
	
	@Override
	public List<Board> list() {
		List<Board> list = new ArrayList<Board>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "selete * from BOARD order by SEQ desc";
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				list.add(new Board(seq, writer, email, subject, content, rdate));
			}
		} catch (SQLException se) {
			log.info("BoardDaoImpl list() se: " + se);
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException se) {
				
			}
		}
		
		return list;
	}

	@Override
	public void insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			log.info("BoardDaoImpl insert() se: " + se);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) pstmt.close();
			} catch (SQLException se) {
				
			}
		}
	}

	@Override
	public Board select(long seq) {
		Board board = new Board();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from BOARD where SEQ=?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			
			board.setSeq(rs.getLong(1));
			board.setWriter(rs.getString(2));
			board.setEmail(rs.getString(3));
			board.setSubject(rs.getString(4));
			board.setContent(rs.getString(5));
			board.setRdate(rs.getDate(6));
		} catch (SQLException se) {
			log.info("BoardDaoImpl select() se: " + se);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException se) {
				
			}
		}

		return board;
	}

	@Override
	public void update(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update BOARD set WRITER = ?, EMAIL = ?, SUBJECT = ?, CONTENT = ? where SEQ = ?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setLong(5, board.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			log.info("BoardDaoImpl update() se: " + se);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException se) {
				
			}
		}
	}

	@Override
	public void delete(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from BOARD where SEQ=?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			log.info("BoardDaoImpl delete() se: " + se);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException se) {
				
			}
		}
	}

}
