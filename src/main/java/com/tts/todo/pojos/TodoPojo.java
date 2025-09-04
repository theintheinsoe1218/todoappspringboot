package com.tts.todo.pojos;

public class TodoPojo {
    private String title;

    public TodoPojo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TodoPojo${title = " + title + "}";
    }
}