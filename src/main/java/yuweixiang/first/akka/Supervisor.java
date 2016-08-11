package yuweixiang.first.akka;

import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

/**
 * akka容错机制
 *
 * @author yuweixiang
 * @version $ Id: Supervisor.java, v 0.1 16/8/8 下午11:59 yuweixiang Exp $
 */
public class Supervisor extends UntypedActor {

    private static SupervisorStrategy strategy = new OneForOneStrategy(10,
        Duration.create("1 minute"), new Function<Throwable, SupervisorStrategy.Directive>() {
            @Override
            public SupervisorStrategy.Directive apply(Throwable t) {
                System.out.println("进入异常处理!");
                if (t instanceof ArithmeticException) {
                    return SupervisorStrategy.resume();
                } else if (t instanceof NullPointerException) {
                    return SupervisorStrategy.restart();
                } else if (t instanceof IllegalArgumentException) {
                    return SupervisorStrategy.stop();
                } else {
                    return SupervisorStrategy.escalate();
                }
            }
        });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    public void onReceive(Object o) {
        System.out.println("supervisor接受到消息:" + o);
        if (o instanceof Props) {
            getSender().tell(getContext().actorOf((Props) o), getSelf());
        } else {
            unhandled(o);
        }
    }
}