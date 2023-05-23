package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.models.board.Board;
import org.koreait.models.board.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class BoardDeleteTest {

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private Board board;


    @Test
    @DisplayName("게시글 삭제 테스트 - 성공시 예외없음")
    void BoardDeleteTest() {
        assertDoesNotThrow(() -> {
            Long id = (Long)board.getId();

           boardDao.delete(id);

        });
    }

}
