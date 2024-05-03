package Class13;

public class timePrcatice_Karishma {
    public static void main(String[] args) {
        Clock firstClock = new Clock(0);
        for (int i = 1; i <= 10 ; i++){
            firstClock.tick();
            System.out.println(firstClock.toString());
        }


        for (int i = 1; i <= 10 ;i++){
            firstClock.tickDown();
            System.out.println(firstClock.toString());
        }
        Clock secondClock = new Clock(12, 0, 0);
        firstClock.addClock(secondClock);

        System.out.println(firstClock.toString());
        System.out.println(secondClock.toString());

        firstClock.subtractClock(secondClock);
    }
}

 class Clock {
    public int hours;
    public int minutes;
    public int seconds;

    public Clock() {
        // TODO implement no args constructor
        hours = 12;
        minutes = 0;
        seconds = 0;

    }

    public Clock(int seconds) {
        hours = seconds/3600;
        minutes = (seconds%3600)/60;
        this.seconds = seconds%(seconds%3600/60);

    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public void tick() {
        //TODO implement this method
        seconds++;

    }


    public void tickDown() {
        //TODO implement this method
        seconds--;

    }

    public void addClock(Clock clock) {
        hours = clock.getHours()+hours;
        minutes = clock.getMinutes()+minutes;
        seconds = clock.getSeconds()+seconds;

        while (seconds > 60) {
            minutes++;
            seconds = seconds%60;
        }
        while (minutes > 60) {
            hours++;
            minutes = minutes%60;
        }
        while (hours > 23) {
            hours = hours - 24;
        }


    }

    public String subtractClock(Clock clock) {
        int h = clock.getHours()-hours;
        int m = clock.getMinutes()-minutes;
        int s = clock.getSeconds()-seconds;

        //TODO implement this method
        return "(" + String.format("%02d:%02d:%02d", h, m, s) + ")";
    }

    @Override
    public String toString() {
        return "(" + String.format("%02d:%02d:%02d", this.getHours(), this.getMinutes(), this.getSeconds()) + ")";
    }
}


