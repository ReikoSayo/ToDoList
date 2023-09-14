package ru.netology.javaqa.javaqamvn.services;

import lombok.Getter;

@Getter
public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] addToArray(String subtask) {
        String[] tmp = new String[subtasks.length + 1];
        for (int i = 0; i < subtasks.length; i++) {
            tmp[i] = subtasks[i];
        }
        tmp[tmp.length - 1] = subtask;
        subtasks = tmp;
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtusk : subtasks) {
            if (subtusk.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
