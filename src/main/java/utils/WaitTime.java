package utils;

public enum WaitTime {
    SHORT(10),   // Short wait time (in seconds)
    MEDIUM(20),  // Medium wait time (in seconds)
    LONG(30);    // Long wait time (in seconds)

    private final int timeInSeconds;

    // Constructor
    WaitTime(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    // Getter method to retrieve the time value
    public int getTimeInSeconds() {
        return timeInSeconds;
    }
}
