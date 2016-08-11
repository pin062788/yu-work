package yuweixiang.first.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.testkit.JavaTestKit;
import akka.testkit.TestProbe;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;

/**
 * 容错测试类
 *
 * @author yuweixiang
 * @version $ Id: FaultHandlingTest.java, v 0.1 16/8/9 上午12:03 yuweixiang Exp $
 */
public class FaultHandlingTest {
    static ActorSystem system;
    Duration           timeout = Duration.create(5, TimeUnit.SECONDS);

    @BeforeClass
    public static void start() {
        system = ActorSystem.create("test");
    }

    @AfterClass
    public static void cleanup() {
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void mustEmploySupervisorStrategy() throws Exception {
        // code here
        Props superprops = Props.create(Supervisor.class);
        ActorRef supervisor = system.actorOf(superprops, "supervisor");
        ActorRef child = (ActorRef) Await.result(ask(supervisor, Props.create(Child.class), 5000),
            timeout);

        child.tell(42, ActorRef.noSender());
        assert Await.result(ask(child, "get", 5000), timeout).equals(42);
//        child.tell(new ArithmeticException(), ActorRef.noSender());
//        child.tell(new NullPointerException(), ActorRef.noSender());
//        assert Await.result(ask(child, "get", 5000), timeout).equals(0);
        final TestProbe probe = new TestProbe(system);
//        probe.watch(child);
//        child.tell(new IllegalArgumentException(), ActorRef.noSender());
//        probe.expectMsgClass(Terminated.class);

        probe.watch(child);
        assert Await.result(ask(child, "get", 5000), timeout).equals(0);
        child.tell(new Exception(), ActorRef.noSender());
        probe.expectMsgClass(Terminated.class);

    }

}
