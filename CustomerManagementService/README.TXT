/*******************System Feature /************

/************API Overview  Customer   Microservice*****************/

Method	              Path	                                                  Description
POST	       |http://localhost:9004/payment/save	                     |Make  Payment data/payment.json
GET	           |http://localhost:9004/payment/{paymentId}	             |get  payment by payment Id 
GET	           |http://localhost:9001/payment	                         |get all payment 
/************Database Configuration*****************/

File Location	src/main/resources/application.properties	
spring.datasource.username = 
spring.datasource.password =