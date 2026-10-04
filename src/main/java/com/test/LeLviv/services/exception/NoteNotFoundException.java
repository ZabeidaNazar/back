package com.test.LeLviv.services.exception;

public class NoteNotFoundException extends Exception {
    private static final String NOTE_NOT_FOUND_EXCEPTION_TEXT = "Нотатки з id %s не знайдено!";

    public NoteNotFoundException(long noteId) {
        super(String.format(NOTE_NOT_FOUND_EXCEPTION_TEXT, noteId));
    }
}
