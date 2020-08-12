package com.motin.diary.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequestDto {
    @NotNull
    private Long id;
}
