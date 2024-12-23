package vyatsu.task2;

import vyatsu.task1.Animal;

public class Ant extends Insects {
    private static final int RUN_LIMIT =50;
    private static final int SWIM_LIMIT =0;
    private static final int lifetime = 48;
    private static int countOfAnt;

    public Ant(String name, int age){
        super(name, age);
        super.setLifetime(lifetime);
        super.setMaxRunDist(RUN_LIMIT);
        super.setMaxSwimDist(SWIM_LIMIT);
        countOfAnt++;
    }
    public static int getCountOfAnt(){return countOfAnt;}
}
