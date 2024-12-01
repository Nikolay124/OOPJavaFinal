package presenter;

import java.time.LocalDateTime;
import java.util.List;

public class NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;

    public NotebookPresenter(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void run() {
        boolean running = true;

        while (running) {
            view.showMenu();
            int choice = view.readChoice();

            switch (choice) {
                case 1:
                    handleAddNote();
                    break;
                case 2:
                    handleShowAllNotes();
                    break;
                case 3:
                    handleFindNotesForDay();
                    break;
                case 4:
                    handleFindNotesForWeek();
                    break;
                case 5:
                    handleSaveToFile();
                    break;
                case 6:
                    handleLoadFromFile();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    view.showErrorMessage("Неправильный выбор. Попробуйте еще раз.");
            }
        }

        view.showGoodbyeMessage();
        ((ConsoleNotebookView) view).closeScanner();
    }

    private void handleAddNote() {
        Note note = view.readNoteInput();
        notebook.addNote(note);
    }

    private void handleShowAllNotes() {
        List<Note> allNotes = notebook.getAllNotes();
        view.displayNotes(allNotes);
    }

    private void handleFindNotesForDay() {
        LocalDateTime day = view.readDateTimeInput();
        List<Note> notesForDay = notebook.filterByDay(day);
        view.displayNotes(notesForDay);
    }

    private void handleFindNotesForWeek() {
        LocalDateTime weekStart = view.readDateTimeInput();
        List<Note> notesForWeek = notebook.findNotesForWeek(weekStart);
        view.displayNotes(notesForWeek);
    }

    private void handleSaveToFile() {
        String filePath = view.readStringInput();
        if (notebook.saveToFile(filePath)) {
            view.showSuccessMessage("Записи успешно сохранены!");
        } else {
            view.showErrorMessage("Ошибка при сохранении записей!");
        }
    }

    private void handleLoadFromFile() {
        String filePath = view.readStringInput();
        if (notebook.loadFromFile(filePath)) {
            view.showSuccessMessage("Записи успешно загружены!");
        } else {
            view.showErrorMessage("Ошибка при загрузке записей!");
        }
    }
}