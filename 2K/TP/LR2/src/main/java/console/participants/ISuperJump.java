package console.participants;

public interface ISuperJump {
    void setTotalSuperJumps(int jumps);
    int getTotalSuperJumps();

    default boolean checkAndUseSuperJump() {
        if (getTotalSuperJumps() > 0) {
            setTotalSuperJumps(getTotalSuperJumps() - 1);
            return true;
        }
        return false;
    }

    default String superJump() {
        return " прыгнул с помощью суперпрыжка.";
    }
}