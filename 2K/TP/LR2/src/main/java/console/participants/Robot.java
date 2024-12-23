package console.participants;

public class Robot implements IParticipant, ISuperRunnable {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean superRunUsed = false;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " успешно пробежал " + distance + " метров.");
            return true;
        } else if (checkAndUseSuperRun(superRunUsed)) {
            superRunUsed = true;
            System.out.println(name + superRun());
            return true;
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров.");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно прыгнул на " + height + " сантиметров.");
            return true;
        } else {
            System.out.println(name + " не смог прыгнуть на " + height + " сантиметров.");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
