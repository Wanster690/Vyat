package vyatsu;

@Table(title = "Ant1")
public class Ant
{
   // @Column
    private String name;
    @Column
    private float lifespan;
    @Column
    private InsectColor color;

    public Ant(String name, float lifespan, InsectColor color)
    {
        this.name = name;
        this.lifespan = lifespan;
        this.color = color;
    }
}

