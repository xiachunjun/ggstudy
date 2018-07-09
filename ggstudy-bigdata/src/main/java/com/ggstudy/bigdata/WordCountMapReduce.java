package com.ggstudy.bigdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.ggstudy.bigdata.map.WordCountMapper;
import com.ggstudy.bigdata.reducer.WordCountReducer;

public class WordCountMapReduce {
	
	public static void main(String[] args) {
		try {
			Configuration conf=new Configuration();
			Job job=Job.getInstance(conf, "WordCount");
			job.setJarByClass(WordCountMapReduce.class);
			job.setMapperClass(WordCountMapper.class);
			job.setReducerClass(WordCountReducer.class);
			//mapper的输出类型
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			//reducer
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.setInputPaths(job, new Path("hdfs://10.214.168.114:9000/words"));
			FileOutputFormat.setOutputPath(job, new Path("hdfs://10.214.168.114:9000/wordcount"));
			
			boolean flag=job.waitForCompletion(true);
			if(!flag){
				System.out.println("WordCountMapReduce failed!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
