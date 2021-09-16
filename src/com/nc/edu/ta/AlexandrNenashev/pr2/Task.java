package com.nc.edu.ta.AlexandrNenashev.pr2;

public class Task {
    String title;
    boolean active;
    int time;
    int start;
    int end;
    int repeat;
    boolean repeated;


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public boolean isActive() {

        return active;
    }

    public void setActive(boolean active) {
        this.active = active;

        if (time <= 0 || start <= 0) {
            active = false;
        } else {
            active = true;
        }
    }

    public void setTime(int time) {
        this.time = time;
        this.repeat = 0;
        this.repeated = false;

    }

    public void setTime(int start, int end, int repeat) {
        this.start = start;
        this.end = end;
        this.repeat = repeat;
        this.repeated = true;
    }

    public int getTime() {
        if (repeated == false) {
            return time;
        } else {
            return start;
        }
    }

    public int getStartTime() {
        if (repeated == true) {
            return start;
        } else {
            return time;
        }
    }

    public int getEndTime() {
        if (repeated == true) {
            return end;
        } else {
            return time;
        }

    }

    public int getRepeatInterval() {
        if (repeated == false) {
            repeat = 0;
        }

        return repeat;
    }

    public boolean isRepeated() {
        if (repeat <= 0) {
            repeated = false;
        } else {
            repeated = true;
        }
        return repeated;
    }


    public String toString() {
        if (active == false) {
            return "Task \"" + title + "\" is inactive";
        }
        if ((active == true) && (repeated == false)) {
            return "Task \"" + title + "\" at " + time;
        }
        if (active && repeated) {
            return "Task \"" + title + "\" from " + start + " to " + end + " every " + repeat + " seconds";
        }
        return "sorry";
    }

    public int nextTimeAfter(int time) {
        if (active) {
            if (!repeated && time < this.time) return this.time;
            if (repeated && time < start) return start;
            if (repeated && time > end) return -1;
            if (repeated && time >= start && time < end){
                int i = start + repeat;
                while (i < end) {
                    if (time < i) {
                        return i;
                    }
                    i += repeat;
                }

            }
            return -1;
        } else {
            return -1;
        }
    }

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
        this.repeated = true;
    }
}





