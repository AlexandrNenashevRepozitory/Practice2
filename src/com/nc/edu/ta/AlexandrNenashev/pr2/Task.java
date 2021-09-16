package com.nc.edu.ta.AlexandrNenashev.pr2;

public class Task {
    String title;
    boolean active;
    int time;
    int start;
    int end;
    int repeat;
    boolean repeated;


    /**
     * getTitle возвращает значение title. title - название задачи.
     */
    public String getTitle() {

        return title;
    }


    /**
     * setTitle устанавливает значение title. title - название задачи.
     */

    public void setTitle(String title) {

        this.title = title;
    }


    /**
     * isActive возвращает значение active. active - индикатор активности задачи.
     */

    public boolean isActive() {

        return active;
    }


    /**
     * setActive устанавливает значение active.
     * Дополнительно с помощью конструкции if мы задали условие - если start или time < или = 0,
     * то active имеет значение false, иначе, active имеет значение true.
     */

    public void setActive(boolean active) {
        this.active = active;

        if (time <= 0 || start <= 0) {
            active = false;
        } else {
            active = true;
        }
    }

    /**
     * Метод setTime устанавливает значение time.
     */

    public void setTime(int time) {
        this.time = time;
        this.repeat = 0;
        this.repeated = false;

    }


    /**
     * Метод setTime устанавливает значение start, end, repeat.
     */

    public void setTime(int start, int end, int repeat) {
        this.start = start;
        this.end = end;
        this.repeat = repeat;
        this.repeated = true;
    }


    /**
     * Метод getTime возвращает значение time если repeated имеет значение false,
     * если repeated = true возвращает start
     */

    public int getTime() {
        if (repeated == false) {
            return time;
        } else {
            return start;
        }
    }


    /**
     * Метод getStartTime возвращает значение time если repeated имеет значение false,
     * если repeated = true возвращает start
     */

    public int getStartTime() {
        if (repeated == true) {
            return start;
        } else {
            return time;
        }
    }


    /**
     * Метод getEndTime возвращает значение end, если repeated = true. В другом случае возвращает time.
     */

    public int getEndTime() {
        if (repeated == true) {
            return end;
        } else {
            return time;
        }

    }


    /**
     * Метод getRepeatInterval возвращает значение repeat = 0, если repeated = false.
     * Иначе возвращает значение repeat.
     */

    public int getRepeatInterval() {
        if (repeated == false) {
            repeat = 0;
        }
        return repeat;
    }


    /**
     * Метод isRepeated возвращает значение repeated. Если repeat <= 0, то repeated = false.
     * Иначе возвращает значение repeated = true.
     */

    public boolean isRepeated() {
        if (repeat <= 0) {
            repeated = false;
        } else {
            repeated = true;
        }
        return repeated;
    }


    /**
     * Метод toString преобразует данные в строковый вид.
     */

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


    /**
     * nextTimeAfter метод возвращающий время следующего оповещения. Если после указанного времени оповещений больше
     * нет или задача неактивна, то результат должен быть -1.
     */

    public int nextTimeAfter(int time) {
        if (active) {
            if (!repeated && time < this.time) return this.time;
            if (repeated && time < start) return start;
            if (repeated && time > end) return -1;
            if (repeated && time >= start && time < end) {
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


    /**
     * Конструктор класса Task для единоразовой задачи.
     */
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }


    /**
     * Конструктор класса Task для повторяющейся задачи.
     */

    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
        this.repeated = true;
    }
}





