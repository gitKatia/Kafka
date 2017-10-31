package com.kat.aio.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author ki
 *
 */
public class KafkaProducerTest {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers","localhost:9092");
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String,String> kProducer = new KafkaProducer<String,String>(properties);
		
		try {
			
			for(int k = 0; k< 10; k++){
				
				ProducerRecord<String,String> pRecord = new ProducerRecord<String,String>("my-first-topic", "m1", "m1-" + k);
				kProducer.send(pRecord);
			}
		}catch(Exception exc){
			
			System.out.println(exc.getMessage());
		} finally {
			
			kProducer.close();
		}
	}
	
	

}
