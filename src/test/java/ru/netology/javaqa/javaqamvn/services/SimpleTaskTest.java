package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleTaskTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    @Test
    void getTitle() {
        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }
}