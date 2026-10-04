package com.test.LeLviv.services;

import com.test.LeLviv.data.entity.Note;
import com.test.LeLviv.data.repository.NoteRepository;
import com.test.LeLviv.services.exception.NoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    public List<Note> listAll() {
        return noteRepository.findAll();
    }
    public Note add(Note note) {
        note.setId(0);
        return noteRepository.save(note);
    }
    public void deleteById(long id) throws NoteNotFoundException {
        noteRepository.deleteById(id);
    }
    public void update(Note note) throws NoteNotFoundException {
        noteRepository.save(note);
    }
    public Note getById(long id) throws NoteNotFoundException {
        Optional<Note> noteInOptional = noteRepository.findById(id);
        if (noteInOptional.isEmpty()) {
            throw new NoteNotFoundException(id);
        }
        return noteInOptional.get();
    }
}
