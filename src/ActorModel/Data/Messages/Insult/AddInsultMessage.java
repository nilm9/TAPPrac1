package ActorModel.Data.Messages.Insult;

import ActorModel.Data.*;
import ActorModel.Data.Messages.Message;

/**
 * Message used to add a new message to the insult list
 *
 */
public class AddInsultMessage extends Message {
    /**
     * Class constructor
     * @param message the message to be sent
     */
    public AddInsultMessage(String message) {
        super(null, message);
    }

    /*
    @Override
    public void setFrom (ActorProxy source){
        super.from=source;
    }*/
}
