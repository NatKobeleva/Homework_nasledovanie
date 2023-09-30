package ru.netology.nasledovanie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesInSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");
        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchesInSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");
        boolean actual = task.matches("Купить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchesInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic task = new Epic(6, subtasks);

        boolean actual = task.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchesInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic task = new Epic(6, subtasks);

        boolean actual = task.matches("Кефир");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchesInMeetingTopic() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = task.matches("Выкатка");

        Assertions.assertTrue(actual);
    }
    @Test
    public void shouldMatchesInMeetingProject() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = task.matches("Банк");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchesInMeeting() {
        Meeting task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = task.matches("понедельник");

        Assertions.assertFalse(actual);
    }
}