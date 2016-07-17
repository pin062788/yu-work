package yuweixiang.first.bigData.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * kafka消息消费者
 *
 * @author yuweixiang
 * @version $ Id: Kafka_consumer.java, v 0.1 16/7/17 下午3:09 yuweixiang Exp $
 */
public class Kafka_consumer {

    private final ConsumerConnector consumer;

    Kafka_consumer() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("group.id", "0");
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        ConsumerConfig config = new ConsumerConfig(props);
        //配置consumer的值
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
    }
    //consumer接收消息
    void consume() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(kafka_produer.topic, new Integer(1));

        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get(kafka_produer.topic).get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext())
            System.out.println(it.next().message());
    }

    public static void main(String[] args) {
        new Kafka_consumer().consume();
    }
}
