package console.obstacles;

public enum WallHeight {
    LOW(100),
    MEDIUM(200),
    HIGH(500);

    private final int height;

    WallHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}