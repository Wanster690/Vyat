package vyatsu.task3;

public class Triton extends Amphibians{
    private static final int RUN_LIMIT = 12;
    private static final int SWIM_LIMIT = 6;
    public static int countOfTriton;
    public Triton(String name, int age, String uniq){
        super(name, age, uniq);
        super.setMaxRunDist(RUN_LIMIT);
        super.setMaxSwimDist(SWIM_LIMIT);
        countOfTriton++;
    }

    public static int getCountOfTriton(){return countOfTriton;}
}
