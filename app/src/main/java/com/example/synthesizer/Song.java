package com.example.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private List<Note> notes;

    public Song() {
        notes = new ArrayList<>();
    }

    public Song(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        return "Song{" +
                "notes=" + notes +
                '}';
    }
}
