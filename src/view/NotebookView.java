package view;

import java.time.LocalDateTime;
import java.util.List;

public interface NotebookView {
    void showMessage(String message);
    void displayNotes(List<Note> notes);
    Note readNoteInput();
    LocalDateTime readDateTimeInput();
    String readStringInput();
}