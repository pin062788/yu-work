package yuweixiang.first.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import java.util.Arrays;

/**
 * 测试类
 *
 * @author yuweixiang
 * @version $ Id: Test.java, v 0.1 16/6/23 上午10:22 yuweixiang Exp $
 */
public class Test {

    public static final void main(String[] args) throws Exception {
        Test launcher = new Test();
        launcher.executeExample();
    }

    public int executeExample() throws Exception {


        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add(ResourceFactory.newClassPathResource("MyTest.drl",
                getClass()),
                ResourceType.DRL);

        if (kbuilder.hasErrors()) {
            System.err.print(kbuilder.getErrors());
            return -1;
        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());


        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();


        FirstDrools order = new FirstDrools();
        order.setSumprice(159);
        ksession.execute(Arrays.asList(new Object[]{order}));


        System.out.println("DISCOUNT IS: " + order.getDiscountPercent());

        return order.getDiscountPercent();
    }
}
