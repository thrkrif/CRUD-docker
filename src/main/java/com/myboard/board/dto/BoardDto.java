package com.myboard.board.dto;

// 데이터를 편하게 주고받기 위함
import com.myboard.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
