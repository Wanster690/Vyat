package console.participants;

public interface ISuperRunnable {
    default boolean checkAndUseSuperRun(boolean superRunUsed) {
        if (!superRunUsed) {
            return true;
        }
        return false;
    }

    default String superRun() {
        return " пробежал с помощью супербега.";
    }
}