package pkb.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkb.board.dao.BoardDao;
import pkb.board.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> listS() {
		return boardDao.list();
	}

	@Override
	public void insertS(Board board) {
		boardDao.insert(board);
	}

	@Override
	public Board selectS(long seq) {
		return boardDao.select(seq);
	}

	@Override
	public void updateS(Board board) {
		boardDao.update(board);
	}

	@Override
	public void deleteS(long seq) {
		boardDao.delete(seq);
	}

}
