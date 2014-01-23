package samples;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxValueMapper extends Mapper<Text, IntWritable, Text, IntWritable> {

}
