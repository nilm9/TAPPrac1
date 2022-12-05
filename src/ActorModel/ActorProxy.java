package ActorModel;

import ActorModel.Messages.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that represents an Actor Proxy, which controls the access to the actor
 */
public class ActorProxy {
    private final Actor actor;
    private final List<Message> receiveQueue;
    protected String id;

    //TODO com fer el recieve i crear el 2n proxy perque no es solapin els sends

    //llista nomes send
    //nomes el pot tenir el proxy
    //es fica a ell mateix com a sender i el actor crida al del proxy

    public ActorProxy(Actor act, String id) {
        this.actor = act;
        this.id = id;
        receiveQueue = Collections.synchronizedList((new ArrayList<>()));
        actor.start();
    }


    public List<Message> getProxyQueue() {
        return receiveQueue;
    }

    public void offer(Message m) {
        receiveQueue.add(m);
    }

    //Añadimos el mensaje obteniendo el actor a través del Actor Context y luego llamando al método offer
    public void send(Message msg) {
        try {
            if (!Message.class.equals(msg.getClass())) {
                msg.setFrom(this);

            }

            //TODO preguntar com hem d'afegir els missatges a la cua de cada actor
            this.actor.offer(msg);
            //Objects.requireNonNull(ActorContext.lookup(id)).cua.offer(msg);
        } catch (NullPointerException e) {
            System.out.println("ACTOR NOT FOUND");
        }
    }

    //Method that processes the message and deletes it from the queue

    public String getProxyId() {
        return this.id;
    }

    public Actor getActor() {
        return this.actor;
    }


    public Message receive() {
        Message m;
//TODO ELIMINAR THREAD Y QUITAR MÉTODO RUN
        while (true) {
            if (!receiveQueue.isEmpty()) {
                System.out.println("ACTOR PROXY *" + id + "* RESPONSE:");
                //Message msg=receiveQueue.get(0);
                m = receiveQueue.get(0);
                System.out.println(m);
                //System.out.println(m);
                receiveQueue.remove(0);
                break;
            }
        }
        return m;
    }
}