package com.motin.diary.controller;

import com.motin.diary.dto.NoteRequestDto;
import com.motin.diary.entity.Note;
import com.motin.diary.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Note> save(@Validated @RequestBody Note note) {
        return ResponseEntity.ok().body(noteService.save(note));
    }

    @GetMapping(path = "/all")
    public List<Note> findAllNote() {
        return noteService.findAll();
    }

    @PostMapping(path = "/find")
    public ResponseEntity<Note> find(@Validated @RequestBody NoteRequestDto noteRequestDto) {
        Note note = noteService.findById(noteRequestDto.getId());
        if (note == null) {
            return (ResponseEntity<Note>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok().body(note);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@Validated @RequestBody NoteRequestDto noteRequestDto){
        return ResponseEntity.ok().body("Deleted successfully");
    }
}
