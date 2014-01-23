package samples;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxValueReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

}
