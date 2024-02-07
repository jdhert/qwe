package com.kitri.springbasicboot.lesson.mybatis.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseTodo {
    Long id;
    String content;
    boolean done;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
}
