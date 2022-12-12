package ActorModel.Observer;

import ActorModel.Actor;

public class ActorListener extends Actor implements Observer {
    Status status = null;

    @Override
    public void update(Status state) {
        System.out.println("Status has been changed to -> " + state);
        status = state;
    }
}
