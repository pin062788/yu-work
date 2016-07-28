package yuweixiang.first.bigData.hadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

/**
 * hadoop应用程序
 *
 * @author yuweixiang
 * @version $ Id: HadoopMapReduce.java, v 0.1 16/7/27 下午11:42 yuweixiang Exp $
 */
public class HadoopMapReduce {

    public static void main(String args[]) throws Exception{
        if (args.length!=2){
            System.out.println("here");
            System.exit(1);
        }
        JobConf jobConf = new JobConf(HadoopMapReduce.class);
        jobConf.setJobName("hadoop map reduce");
        FileInputFormat.addInputPath(jobConf,new Path(args[0]));
        FileOutputFormat.setOutputPath(jobConf,new Path(args[1]));
        jobConf.setMapperClass(HadoopMap.class);
        jobConf.setReducerClass(HadoopReduce.class);
        jobConf.setOutputKeyClass(Text.class);
        jobConf.setOutputValueClass(IntWritable.class);
        JobClient.runJob(jobConf);
    }
}
