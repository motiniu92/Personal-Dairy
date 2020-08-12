package com.motin.diary.service.serviceImpl;

import com.motin.diary.entity.Note;
import com.motin.diary.entity.Note;
import com.motin.diary.repository.NoteRepository;
import com.motin.diary.service.NoteService;
import com.motin.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;
    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    @Override
    public Note save(Note note) {
        if(note != null){
            note = noteRepository.save(note);
            log.info("note:{}",note);
        }
        return note;
    }

    @Override
    public List<Note> saveAll(List<Note> categories) {
        if(categories !=null && !categories.isEmpty()){
            categories = noteRepository.saveAll(categories);
            log.info("categories:{}",categories);
        }
        return categories;
    }

    @Override
    public void delete(Long id) {
        if(id != null){
            Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
            noteRepository.delete(note);
        }
    }

    @Override
    public List<Note> findAll() {
        List<Note> categories = noteRepository.findAll();
        log.info("categories:{}",categories);
        return categories;
    }

    @Override
    public Note findById(Long id) {
        Note note  = null;
        if(id != null){
            Optional<Note> optionalNote = noteRepository.findById(id);
            if(optionalNote.isPresent()){
                note = optionalNote.get();
            }else {
                throw new RuntimeException("Note not found");
            }
        }else {
            throw new RuntimeException("Invalid id");
        }
        log.info("note:{}",note);
        return note;
    }
}
