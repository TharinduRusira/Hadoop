package samples;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxValueMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	private static final int MISSING = 9999;
	@Override
	public void map(LongWritable key,Text value,Context context) 
			throws IOException,InterruptedException{
		String line = value.toString();
		String year = line.substring(15,19);
		long airTemperature;
		if(line.charAt(87) == '+'){
			airTemperature = Long.parseLong(line.substring(88,92));
		}else{
			airTemperature= Long.parseLong(line.substring(87, 92));
		}
		String quality = line.substring(92, 93);
		if(airTemperature != MISSING && quality.matches("[01459]")){
			context.write(new Text(year), new LongWritable(airTemperature));
		}
	}
}
