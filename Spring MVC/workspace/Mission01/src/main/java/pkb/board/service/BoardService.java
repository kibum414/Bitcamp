package pkb.board.service;

import java.util.List;

import pkb.board.domain.Board;

public interface BoardService {
	List<Board> listS();
	void insertS(Board board);
	Board selectS(long seq);
	void updateS(Board board);
	void deleteS(long seq);
}
