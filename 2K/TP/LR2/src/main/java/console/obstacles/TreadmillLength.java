package console.obstacles;

public enum TreadmillLength {
    LOW(500),
    MEDIUM(1000),
    HIGH(1500);

    private final int length;

    TreadmillLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
