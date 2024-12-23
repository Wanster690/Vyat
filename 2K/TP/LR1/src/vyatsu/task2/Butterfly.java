package vyatsu.task2;

public class Butterfly extends Insects {
    private static final int RUN_LIMIT = 0;
    private static final int SWIM_LIMIT = 0;
    private static final int lifetime = 12;
    private static int countOfButterfly;

    public Butterfly(String name, int age){
        super(name, age);
        super.setMaxRunDist(RUN_LIMIT);
        super.setMaxSwimDist(SWIM_LIMIT);
        super.setLifetime(lifetime);
        countOfButterfly++;
    }


    public static int getCountOfButterfly(){return countOfButterfly;}
}
