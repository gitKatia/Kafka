Spring Boot Web Application with admin functionalities (Manage Kafka Cluster)

* Start, Stop Zookeeper
* Start, Stop Brokers
* Visualize, add, edit, remove topics

The Kafka distribution used is kafka_2.11-0.11.0.1

You should define an environment variable named KAFKA_BIN pointing to the folder where the scripts are located in the Kafka distribution:
* bin for Macbook or Unix users
* bin/windows for Windows users

From the command line the web application can be started typing:

java -jar <jarName>.jar
 
In STS (Spring Tool Suite) the web application can be started this way:

Run As > Run Configurations

Environment Tab -> New Environment variable KAFKA_BIN pointng to the Kafka scripts folder.

After the application is started, it can be accessed at:

localhost:8080
