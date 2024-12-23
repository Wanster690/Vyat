package console.obstacles;

import console.participants.IParticipant;
import console.participants.ISuperRunnable;

public class Treadmill  implements IObstacle {
    int length;

    public Treadmill(TreadmillLength treadmillLength) {
        this.length = treadmillLength.getLength();
    }

    @Override
    public boolean isOvercome(IParticipant participant) {
        return participant.run(length);
    }
}
