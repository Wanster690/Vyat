package console;

import console.obstacles.*;
import console.participants.Cat;
import console.participants.Human;
import console.participants.IParticipant;
import console.participants.Robot;

public class Main {
    public static void main(String[] args) {

        IParticipant[] participants = {
                new Human("Human", 1000, 200),
                new Cat("Cat 1", 1200, 400),
                new Cat("Cat 2", 1200, 400),
                new Robot("Robot", 500, 500)
        };

        IObstacle[] obstacles = {
                new Treadmill(TreadmillLength.LOW),
                new Wall(WallHeight.LOW),
                new Wall(WallHeight.HIGH),
                new Treadmill(TreadmillLength.HIGH),
                new Wall(WallHeight.HIGH),
                new Wall(WallHeight.HIGH)


        };
        for (IParticipant p : participants) {
            for (IObstacle o : obstacles) {
                if (!o.isOvercome(p)) break;
            }
        }
    }
}

