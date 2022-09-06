package controllers;

import javax.swing.JPanel;

/*
 * Gán nhãn cho các panel
 */
/**
 *
 * @author Hien Phan
 */
public class Task {

    private String task;
    private JPanel jpn;

    public Task(String task, JPanel jpn) {
        this.task = task;
        this.jpn = jpn;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
}
