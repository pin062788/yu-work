package yuweixiang.first.akka;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;

public class ActorWatch extends UntypedActor{

    private ActorRef a = context().system().deadLetters();

    public ActorWatch(ActorRef other) {
        context().watch(other);

    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Terminated) {
            a.tell(message.toString() + "is finished", ActorRef.noSender());
        }
    }
}
