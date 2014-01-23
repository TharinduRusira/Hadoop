package samples;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import sorter.MapRedSort;
import sorter.SortMapper;
import sorter.SortReducer;

/**
 * DISCLAIMER
 * program code in samples package are taken from the examples provided in 
 * Hadoop The Definitive Guide 3rd Edition
 * 
 * 
 *
 */
public class MaxValue {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		if (args.length != 2) {
			System.err.println("Usage: MaxTemperature <input path> <output path>");
			System.exit(-1); 
		}
		
		Job  job = new Job();
		job.setJarByClass(MapRedSort.class);
		job.setJobName("Map Reduce sort");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(SortMapper.class);
		job.setReducerClass(SortReducer.class);
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true)? 0 : 1);
		
	}

}
