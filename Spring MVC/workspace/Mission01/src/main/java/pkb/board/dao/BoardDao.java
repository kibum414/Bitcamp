package pkb.board.dao;

import java.util.List;

import pkb.board.domain.Board;

public interface BoardDao {
	List<Board> list();
	void insert(Board board);
	Board select(long seq);
	void update(Board board);
	void delete(long seq);
}
