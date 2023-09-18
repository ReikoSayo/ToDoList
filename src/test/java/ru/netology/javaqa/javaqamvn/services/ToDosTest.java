package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ToDosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    ToDos todos = new ToDos();

    @BeforeEach
    void add() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchInTodosEpicTest() {
        String query = "Молоко";
        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTopicMeetingInTodosTest() {
        String query = "Выкатка";
        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchProjectMeetingInTodosTest() {
        String query = "НетоБанка";
        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchSimpleTaskInTodosTest() {
        String query = "Позвонить";
        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    SimpleTask simpleTask2 = new SimpleTask(7, "Позвонить сестре");

    @Test
    void searchTwoSimpleTaskInTodosTest() {
        todos.add(simpleTask2);
        String query = "Позвонить";
        Task[] expected = {simpleTask, simpleTask2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    String[] subtasks2 = {"Позвонить Яне", "Позвонить Илье"};
    Epic epic2 = new Epic(57, subtasks2);

    @Test
    void searchTwoTaskInTodosTest() {
        todos.add(epic2);
        String query = "Позвонить";
        Task[] expected = {simpleTask, epic2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void noSearchTaskInTodosTest() {
        String query = "Родители";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}