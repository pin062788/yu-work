package yuweixiang.first.bigData.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

/**
 * hadoop类中的map封装类
 *
 * @author yuweixiang
 * @version $ Id: HadoopMap.java, v 0.1 16/7/27 下午11:30 yuweixiang Exp $
 */
public class HadoopMap extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable> {

    @Override
    public void map(LongWritable longWritable, Text text, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        String line = text.toString();
        outputCollector.collect(new Text("a"),new IntWritable(1));
    }
}
