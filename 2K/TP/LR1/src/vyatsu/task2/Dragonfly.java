package vyatsu.task2;


public class Dragonfly extends Insects {
    private static final int RUN_LIMIT = 0;
    private static final int SWIM_LIMIT = 0;
    private static final int lifetime = 36;
    private static final int maxFlyDist = 200;
    private static int countOfDragonfly;


    public Dragonfly(String name, int age){
        super(name, age);
        super.setMaxRunDist(RUN_LIMIT);
        super.setMaxSwimDist(SWIM_LIMIT);
        super.setLifetime(lifetime);
        countOfDragonfly++;

    }
    public static int getCountOfDragonfly(){return countOfDragonfly;}

public void fly(int distance){
            if (distance>maxFlyDist){
                System.out.println(super.getName()+" не может пролететь "+ distance + " м");
            }else {
                System.out.println(super.getName()+ " пролетел "+ distance + " м");
            }
        }

}
