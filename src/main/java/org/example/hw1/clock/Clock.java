package org.example.hw1.clock;

public class Clock implements Readable{
    int hour;
    int minutes;
    int seconds;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void tick(){
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }

        }
    }

    @Override
    public void readTime() {
        System.out.println(getHour()+":"+getMinutes()+":"+getSeconds());
    }
}
