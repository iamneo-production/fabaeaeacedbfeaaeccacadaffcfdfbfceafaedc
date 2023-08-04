package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "abc1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String taskHolderName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date taskDate;
    private String taskName;
    private String taskStatus;

    @Override
    public String toString() {
        return "user [taskDate=" + taskDate + ", taskHolderName=" + taskHolderName + ", taskId=" + taskId
                + ", taskName=" + taskName + ", taskStatus=" + taskStatus + "]";
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskHolderName() {
        return taskHolderName;
    }

    public void setTaskHolderName(String taskHolderName) {
        this.taskHolderName = taskHolderName;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

}