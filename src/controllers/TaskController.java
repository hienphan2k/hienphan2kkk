/*
 * xu ly khi chon cac task tai MainFrame
 */
package controllers;

import displays.Function1;
import displays.Function1Manager.HoKhau;
import displays.Function1Manager.NhanKhau;
import displays.Function23467;
import displays.Function5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Hien Phan
 */
public class TaskController {

    private JPanel root;
    private String taskSelected;
    private List<Task> tasks;

    public TaskController() {
    }

    public TaskController(JPanel root, List<Task> tasks) {
        this.root = root;
        this.tasks = tasks;
    }

    //hien thi taskSelected trên workplace
    public void setDisplay(String taskSelected, JPanel jpnTask) {
        this.taskSelected = taskSelected;
        setDefaultColor();
        jpnTask.setBackground(new Color(204, 255, 255));
        JPanel display;
        switch (taskSelected) {
            case "Function1" ->
                display = new Function1();
            case "Function5" ->
                display = new Function5();
            case "NhanKhau" ->
                display = new NhanKhau();
            case "HoKhau" ->
                display = new HoKhau();
            default -> {
                display = new Function23467();
            }

        }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(display);
        root.validate();
        root.repaint();
    }

    public void setDefaultColor() {
        tasks.forEach((item) -> {
            item.getJpn().setBackground(new Color(236, 236, 236));
        });
    }

    //xu ly su kien khi dung chuot
    public void setEvent() {
        tasks.forEach((item) -> {
            item.getJpn().addMouseListener(new panelEvent(item.getTask(), item.getJpn()));
        });
    }

    class panelEvent implements MouseListener {

        private String task;
        private JPanel jpnTask;

        public panelEvent(String task, JPanel jpnTask) {
            this.task = task;
            this.jpnTask = jpnTask;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            setDisplay(task, jpnTask);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnTask.setBackground(new Color(204, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!task.equals(taskSelected)) {
                jpnTask.setBackground(new Color(236, 236, 236));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }
}
