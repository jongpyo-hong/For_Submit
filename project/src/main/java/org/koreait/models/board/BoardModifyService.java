package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardModifyService {
    @Autowired
    private BoardDao boardDao;

    public void modify(Long id) {
        boardDao.modify(id);
    }
}
