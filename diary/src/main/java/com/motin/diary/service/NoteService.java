package com.motin.diary.service;

import com.motin.diary.entity.Note;
import com.motin.diary.entity.User;

import java.util.List;

public interface NoteService {
    Note save(Note note);
    List<Note> saveAll(List<Note> notes);
    void delete(Long id);
    List<Note> findAll();
    Note findById(Long id);
}
