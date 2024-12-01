package view;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView implements NotebookView {
    private Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayNotes(List<Note> notes) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            System.out.printf("%d. %s - %s\n", i + 1, note.getDateTime(), note.getDescription());
        }
    }

    @Override
    public Note readNoteInput() {
        System.out.println("Введите дату и время записи (YYYY-MM-DD HH:mm): ");
        LocalDateTime dateTime = readDateTimeInput();

        System.out.println("Описание записи: ");
        String description = readStringInput();

        return new Note(dateTime, description);
    }

    @Override
    public LocalDateTime readDateTimeInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return LocalDateTime.parse(input, DATE_TIME_FORMATTER);
            } catch (DateTimeException e) {
                showMessage("Неверный формат даты и времени! Попробуйте снова.");
            }
        }
    }

    @Override
    public String readStringInput() {
        return scanner.nextLine();
    }

    // Закрытие сканера при завершении программы
    public void closeScanner() {
        scanner.close();
    }
}