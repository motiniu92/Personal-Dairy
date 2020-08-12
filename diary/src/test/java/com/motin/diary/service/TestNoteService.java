package com.motin.diary.service;

import com.motin.diary.entity.Category;
import com.motin.diary.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class TestNoteService {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void insertNotes(){
        Category category1 = categoryService.findByCategoryName("Home");
        Note note1 = new Note();
        note1.setDescription("My Budget for this month of family is : 20000 tk");
        note1.setCategory(category1);

        Category category2 = categoryService.findByCategoryName("Work");
        Note note2 = new Note();
        note2.setDescription("My Budget for this month for Transportation is : 2000 tk");
        note2.setCategory(category2);

        Category category3 = categoryService.findByCategoryName("All");
        Note note3 = new Note();
        note3.setDescription("My Budget for this month in total is : 200000 tk");
        note3.setCategory(category3);

        Category category4 = categoryService.findByCategoryName("Others");
        Note note4 = new Note();
        note4.setDescription("My Budget for this month of others is : 200 tk");
        note4.setCategory(category4);

        List<Note> notes = noteService.saveAll(Arrays.asList(note1,note2,note3,note4));
        log.info("notes:{}",notes);
    }

    @Test
    public void testDeleteNote(){
        Note note = noteService.findById(5L);
        noteService.delete(note.getId());
    }
}
