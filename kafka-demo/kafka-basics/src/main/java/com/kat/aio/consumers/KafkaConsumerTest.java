package com.kat.aio.consumers;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerTest {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("bootstrap.servers","localhost:9092");
		properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id", "consumers-g1");
		
		KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(properties);
		
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("my-first-topic");
		consumer.subscribe(topics);
		
		try {
			while(true){
				ConsumerRecords<String, String> records = consumer.poll(10);
				
				for(ConsumerRecord<String, String> record:records){
					System.out.println("Record:" + record.toString());
				}
			}
		} catch(Exception exc){
			System.err.println(exc.getMessage());
		} finally {
			consumer.close();
		}
	}

}
