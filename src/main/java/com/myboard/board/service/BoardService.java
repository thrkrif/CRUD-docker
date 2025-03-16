package com.myboard.board.service;

import com.myboard.board.domain.Board;
import com.myboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService{
    private final BoardRepository boardRepository;

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    public Board findOne(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void create(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void update(Long id, String title, String content) {
        Board findBoard = boardRepository.findById(id).orElseThrow(NullPointerException::new); // JPA 영속성 컨텍스트 ? DB 캐시에 접근
        findBoard.setTitle(title);
        findBoard.setContent(content);
    }

    @Transactional
    public void delete(Board board) {
        boardRepository.delete(board);
    }
}
