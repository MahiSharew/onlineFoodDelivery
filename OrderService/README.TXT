System Feature 

Order food by choosing different menu item, quantity
Get valid payment information from payment Microservices 
Send Email about order information to customer 
logging  every  API call and save it in data/loggingfile.txt

/************API Overview  Order Microservice*****************/

Method	              Path	                                                  Description
POST	       |http://localhost:9001/api/orders/	                     |create order, using sample data (data/order.json)
GET	           |http://localhost:9001/api/orders/	                     |get all orders
GET	           |http://localhost:9001/api/orders/{orderId}	             |get an order by order id.
GET	           |http://localhost:9001/api/orders//{userId}/orders	     |get all the orders placed by one user


/************Database Configuration*****************/

File Location	src/main/resources/application.properties	
spring.datasource.username = 
spring.datasource.password =

/************RabbitMQ Configuration*****************/
File Location	src/main/resources/application.properties
Update Attribute	spring.rabbitmq.host = localhost
spring.rabbitmq.port = 5672
spring.rabbitmq.username = guest
spring.rabbitmq.password = guest

/************Email Configuration*****************/

File Location	     src/main/resources/application.yml

Update Attribute	  
username: yohannsborena@gmail.com
password: Pass123*
port: 587
