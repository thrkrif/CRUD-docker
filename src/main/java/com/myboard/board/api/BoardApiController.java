package com.myboard.board.api;

import com.myboard.board.domain.Board;
import com.myboard.board.dto.BoardDeleteDto;
import com.myboard.board.dto.BoardDto;
import com.myboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService; // Autowired로 스프링 빈에 등록

    @GetMapping("/api/board-list")
    public WrapperClass board_list(){
        List<Board> boardList = boardService.findBoards();
        List<BoardDto> boardDtoList = boardList.stream().map(b -> new BoardDto(b)).collect(Collectors.toList());
        return new WrapperClass(boardDtoList);
    }

    @GetMapping("/api/board-detail/{boardId}")
    public WrapperClass board_detail(@PathVariable("boardId") Long boardId){
        Board board = boardService.findOne(boardId);
        BoardDto boardDto = new BoardDto(board);
        return new WrapperClass(boardDto);
    }

    @PostMapping("/api/create-board")
    public ResponseEntity create_board(@RequestBody BoardDto boardDto){
        System.out.println("create_board/boardDto = " + boardDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED; // 201 잘 생성되었음을 의미
        try{
            Board board = new Board(
                    boardDto.getId(),
                    boardDto.getTitle(),
                    boardDto.getContent()
            );
            boardService.create(board);
            body.put("message", "Board created successfully");  // 성공 메시지 추가
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST; // 400 에러
            System.out.println("create_board/exception = " + exception);
            body.put("error", exception.getMessage());  // 오류 메시지 추가
        }
        return new ResponseEntity(body, headers, status);
    }

    @PutMapping("/api/update-board")
    public ResponseEntity update_board(@RequestBody BoardDto boardDto){
        System.out.println("update_board/boardDto = " + boardDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT; // 204 -> 수정이 정상적으로 완료됬음을 의미
        try{
            boardService.update(boardDto.getId(), boardDto.getTitle(), boardDto.getContent());
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST; // 400 에러
            System.out.println("update_board/exception = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

    @DeleteMapping("/api/delete-board")
    public ResponseEntity delete_board(@RequestBody BoardDeleteDto boardDeleteDto){
        System.out.println("delete_board/boardDeleteDto = " + boardDeleteDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT;
        try{
            Board board = boardService.findOne(boardDeleteDto.getId());
            boardService.delete(board);
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST;
            System.out.println("delete_board/exception = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

}