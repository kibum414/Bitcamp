package pkb.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkb.board.dao.BoardDao;
import pkb.board.domain.Board;
import pkb.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	// private BoardDao boardDao;
	
	@Override
	public List<Board> listS() {
		return boardMapper.list();
		// return boardDao.list();
	}

	@Override
	public void insertS(Board board) {
		boardMapper.insert(board);
		// boardDao.insert(board);
	}

	@Override
	public Board selectS(long seq) {
		return boardMapper.select(seq);
		// return boardDao.select(seq);
	}

	@Override
	public void updateS(Board board) {
		boardMapper.update(board);
		// boardDao.update(board);
	}

	@Override
	public void deleteS(long seq) {
		boardMapper.delete(seq);
		// boardDao.delete(seq);
	}

}
