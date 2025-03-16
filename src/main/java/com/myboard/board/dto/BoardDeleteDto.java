package com.myboard.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDeleteDto {
    private Long id;

    public BoardDeleteDto(Long id) {
        this.id = id;
    }

}
