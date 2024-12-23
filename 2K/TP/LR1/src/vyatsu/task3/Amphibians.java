package vyatsu.task3;

import vyatsu.task1.Animal;

public abstract class Amphibians extends Animal {
    private String uniq;
    private static int countOfAmphibians;

    public Amphibians(String name, int age, String uniq){
        super(name, age);
        this.uniq = uniq;
        countOfAmphibians++;
    }
    public static int getCountOfAmphibians(){
        return countOfAmphibians;
    }


    public String uniqueness(){return (this.uniq);}
}
