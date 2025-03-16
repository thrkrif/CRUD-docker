package com.myboard.board.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WrapperClass<E> {
    private E data;
}