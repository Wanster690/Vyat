package vyatsu.task3;

public class Frog extends Amphibians{
    public static int countOfFrog;
    public Frog(String name, int age, String uniq){
        super(name, age, uniq);
        countOfFrog++;
    }
    public static int getCountOfFrog(){return countOfFrog;}
}
