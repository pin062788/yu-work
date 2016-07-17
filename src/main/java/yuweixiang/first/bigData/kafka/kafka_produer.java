package yuweixiang.first.bigData.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka消息生产者
 *
 * @author yuweixiang
 * @version $ Id: kafka_produer.java, v 0.1 16/7/17 下午3:09 yuweixiang Exp $
 */
public class kafka_produer {
    //定义一个produce的参数
    private final KafkaProducer<Integer, String> producer;
    //定义topic
    public final static String topic = "topic1";


    kafka_produer() {
        //给producer属性赋值
        Map<String, String> props = new HashMap<String, String>();
        //序列化 防止在转换的时候抛出异常
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //配置kafka broker list的地址
        props.put("bootstrap.servers", "localhost:9092");      //配置kafka broker list的地址
        props.put("zk.connect", "localhost:2181");
        //将producer 的属性值赋值进去
        producer = new KafkaProducer(props);

    }

    //发消息的
    void produce() throws InterruptedException {
        int messageNo = 1;
//        while (true) {
        try {
            String key = new String("hello kafka message " + messageNo);
            //发送消息
            producer.send(new ProducerRecord<Integer, String>(topic, key));
            System.out.println("send OK");
        } finally {
            Thread.sleep(2000);
        }
        messageNo++;
//        }
    }


    public static void main(String[] args) throws InterruptedException {
        new kafka_produer().produce();
        try{
            Thread.sleep(200000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}