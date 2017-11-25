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
		// Broker the Kafka Producer connects to
		properties.put("bootstrap.servers","localhost:9092");
		// The Key decides the partition for the Record
		// Key Serializer used by the Producer
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		// Payload Serializer used by the Producer
		properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String,String>(properties);
		
		try {
			
			for(int k = 0; k< 10; k++){
				
				ProducerRecord<String,String> producerRecord = 
						new ProducerRecord<String,String>("my-first-topic", "m1", "m1-" + k);
				kafkaProducer.send(producerRecord);
			}
		}catch(Exception exc){
			
			System.out.println(exc.getMessage());
		} finally {
			
			kafkaProducer.close();
		}
	}
	
	

}
