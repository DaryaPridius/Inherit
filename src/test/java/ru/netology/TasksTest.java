package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TasksTest {

    @Test
    public void searchForTaskWithAnExistingQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(77, "Отправить задание на проверку");
        String query = "задание";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchForTaskWithNotExistingQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(77, "Отправить задание на проверку");
        String query = "решить";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void performSearchWhenTheSubtaskDoesNotExist() {
        String[] subtasks = {"Стол", "Кресло", "Торшер"};
        Epic epic = new Epic(28, subtasks);
        String query = "Шкаф";

        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void performSearchWhenTheSubtaskExist() {
        String[] subtasks = {"Стол", "Кресло", "Торшер", "Шкаф"};
        Epic epic = new Epic(28, subtasks);
        String query = "Шкаф";

        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void performSearchOnTheTopicOfTheDiscussion() {
        Meeting meeting = new Meeting(19, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        String query = "Выкатка";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void performSearchByProjectName() {
        Meeting meeting = new Meeting(19, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        String query = "Приложение";

        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void performSearchBasedOnDataThatIsNotInTheTask() {
        Meeting meeting = new Meeting(19, "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        String query = "Анализ";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
