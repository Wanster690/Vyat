package vyatsu.task3;

public class Chameleon extends Amphibians {
    private static final int RUN_LIMIT = 7;
    private static final int SWIM_LINIT = 0;
    public static int countOfChameleon;
    public Chameleon(String name, int age, String uniq){
        super(name, age, uniq);
        super.setMaxRunDist(RUN_LIMIT);
        super.setMaxSwimDist(SWIM_LINIT);
        countOfChameleon++;
    }

    public static int getCountOfChameleon(){return countOfChameleon;}
}
