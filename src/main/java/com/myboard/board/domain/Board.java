package com.myboard.board.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data // @Getter @Setter
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id, title"})
public class Board {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
