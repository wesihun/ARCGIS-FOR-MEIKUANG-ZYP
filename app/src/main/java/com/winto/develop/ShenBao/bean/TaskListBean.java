package com.winto.develop.ShenBao.bean;

import com.winto.develop.ShenBao.base.BaseResponse;

public class TaskListBean extends BaseResponse {
    private String taskName;
    private String taskInfo;
    private String time;
    private int taskState;

    public TaskListBean() {
    }

    public TaskListBean(String taskName, String taskInfo, String time, int taskState) {
        this.taskName = taskName;
        this.taskInfo = taskInfo;
        this.time = time;
        this.taskState = taskState;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTaskState() {
        return taskState;
    }

    public void setTaskState(int taskState) {
        this.taskState = taskState;
    }
}
