package yuweixiang.first.akka;

import akka.actor.*;

/**
 * actor传递测试
 *
 * @author yuweixiang
 * @version $ Id: AkkaPost.java, v 0.1 16/8/7 下午10:15 yuweixiang Exp $
 */
public class AkkaPost {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo-java");
        ActorRef bob = system.actorOf(Greeter.props("Bob", "Howya doing"));
        ActorRef alice = system.actorOf(Greeter.props("Alice", "Happy to meet you"));
        ActorRef watch = system.actorOf(Props.create(ActorWatch.class,bob));
        ActorRef watch1 = system.actorOf(Props.create(ActorWatch.class,alice));
        bob.tell(new Greet(alice), ActorRef.noSender());
        alice.tell(new Greet(bob), ActorRef.noSender());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            /* ignore */ }
        system.shutdown();
    }

    // messages
    private static class Greet {
        public final ActorRef target;

        public Greet(ActorRef actor) {
            target = actor;
        }
    }

    private static Object AskName = new Object();

    private static class TellName {
        public final String name;

        public TellName(String name) {
            this.name = name;
        }
    }

    // actor implementation
    private static class Greeter extends UntypedActor {
        private final String myName;
        private final String greeting;

        Greeter(String name, String greeting) {
            myName = name;
            this.greeting = greeting;
        }

        public static Props props(String name, String greeting) {
            return Props.create(Greeter.class, name, greeting);
        }

        public void onReceive(Object message) throws Exception {
            if (message instanceof Greet) {
                ((Greet) message).target.tell(AskName, self());
            } else if (message == AskName) {
                sender().tell(new TellName(myName), self());
            } else if (message instanceof TellName) {
                System.out.println(greeting + ", " + ((TellName) message).name);
            }
        }
    }
}
