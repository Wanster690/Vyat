package console.participants;

public interface IParticipant {
    String getName();
    boolean run(int distance);
    boolean jump(int height);
}
