package src.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    // Добавление новой записи
    public void addNote(Note note) {
        if (!notes.contains(note)) {
            notes.add(note);
        }
    }

    // Получение списка всех записей
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }

    // Сортировка записей по времени
    public List<Note> sortByDateTime() {
        List<Note> sortedNotes = new ArrayList<>(notes);
        sortedNotes.sort((n1, n2) -> n1.getDateTime().compareTo(n2.getDateTime()));
        return sortedNotes;
    }

    // Фильтрация записей по дню
    public List<Note> filterByDay(LocalDateTime day) {
        LocalDateTime startOfDay = day.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        return notes.stream()
                .filter(note -> note.getDateTime().isAfter(startOfDay) && note.getDateTime().isBefore(endOfDay))
                .toList();
    }

    // Поиск записей за неделю
    public List<Note> findNotesForWeek(LocalDateTime weekStart) {
        LocalDateTime nextMonday = weekStart.plusWeeks(1); // следующая неделя

        return notes.stream()
                .filter(note -> !note.getDateTime().isBefore(weekStart) && !note.getDateTime().isAfter(nextMonday))
                .sorted((n1, n2) -> n1.getDateTime().compareTo(n2.getDateTime()))
                .toList();
    }

    // Сохранение записей в файл
    public boolean saveToFile(String filePath) {
        // Логика сохранения в файл
        return true;
    }

    // Загрузка записей из файла
    public boolean loadFromFile(String filePath) {
        // Логика загрузки из файла
        return false;
    }
}