package yuweixiang.first.akka;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import scala.Option;
import scala.concurrent.duration.Duration;

//import static akka.pattern.Patterns.ask;

/**
 * akka模型消息发送者
 *
 * @author yuweixiang
 * @version $ Id: AkkaProvider.java, v 0.1 16/8/7 下午2:21 yuweixiang Exp $
 */
public class AkkaProvider extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void preStart() {
        System.out.println("start");
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> a) throws Exception {
        System.out.println("preRestart");
        super.preRestart(reason, a);
    }

    //    @Override
    //    public void postRestart(Throwable reason) {
    //        System.out.println("postRestart");
    //        preStart();
    //    }

    @Override
    public void postStop() {
        System.out.println("stop");
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            System.out.println("reveive message" + message);
            log.info("log receive message is :" + message);
            //            throw new RuntimeException("测试异常");
            // 重新制定方法
            //            getContext().become(new Procedure<Object>() {
            //                public void apply(Object message) {
            //                    if (message instanceof String) {
            //                        System.out.println("inner reveive message1" + message);
            //                        // 慎用
            //                        //                        getContext().unbecome();
            //                    }
            //                }
            //            }, false);
        }
    }

    private static SupervisorStrategy strategy = new OneForOneStrategy(10,
        Duration.create("1 minute"), new Function<Throwable, SupervisorStrategy.Directive>() {

            @Override
            public SupervisorStrategy.Directive apply(Throwable t) {
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

    /**
     * main函数
     *
     * @param args 输入参数
     */
    public static void main(String args[]) {
        try {
            ActorSystem actorSystem = ActorSystem.create("first-akka");
            ActorRef actorRef = actorSystem.actorOf(Props.create(AkkaProvider.class));
            actorRef.tell("you are good", ActorRef.noSender());
            actorRef.tell("you are good", ActorRef.noSender());
            //            Future<Object> t = ask(actorRef, "you are good", 1000);
            ActorRef watch = actorSystem.actorOf(Props.create(ActorWatch.class, actorRef));
            //            watch.tell(actorRef,ActorRef.noSender());
            actorSystem.stop(actorRef);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            actorSystem.shutdown();
        } catch (Exception e) {
            System.out.println("出错了:"+e);
        }
    }
}
