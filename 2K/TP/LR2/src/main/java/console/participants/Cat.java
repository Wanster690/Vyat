package console.participants;

public class Cat implements IParticipant, ISuperRunnable, ISuperJump {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean superRunUsed = false;
    private static int totalSuperJumps = 2;

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(this.name + " успешно пробежал " + distance + " метров.");
            return true;
        } else if (checkAndUseSuperRun(superRunUsed)) {
            superRunUsed = true;
            System.out.println(this.name + superRun());
            return true;
        } else {
            System.out.println(this.name + " не смог пробежать " + distance + " метров.");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(this.name + " успешно прыгнул на " + height + " сантиметров.");
            return true;
        } else if (checkAndUseSuperJump()) {
            System.out.println(this.name + superJump());
            return true;
        } else {
            System.out.println(this.name + " не смог прыгнуть на " + height + " сантиметров.");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalSuperJumps() {
        return totalSuperJumps;
    }

    @Override
    public void setTotalSuperJumps(int jumps) {
        this.totalSuperJumps = jumps;
    }
}
