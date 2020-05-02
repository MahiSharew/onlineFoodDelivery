/************System Feature *****************/

Upload Restaurant information 
Get all restaurant and food information  
Find Restaurant by restaurant ID
logging  every  API call and save it in data/loggingfile.txt

/************API Overview  Order Microservice*****************/

Method	              Path	                                                  Description
POST	       |http://localhost:9002/api/restaurants/	                 |save restaurant information, using sample data (data/order.json)
GET	           |http://localhost::9002/api/restaurants/                  |Get all restaurants information
GET	           |http://localhost:9002/api//restaurants/{restaurantId}	 |Get restaurant by restaurant Id


/************Database Configuration*****************/
Database Name :dreamrestaurant
File Location	src/main/resources/application.properties	
spring.datasource.username = 
spring.datasource.password =

/************RabbitMQ Configuration*****************/
File Location	src/main/resources/application.properties
Update Attribute	spring.rabbitmq.host = localhost
spring.rabbitmq.port = 5672
spring.rabbitmq.username = guest
spring.rabbitmq.password = guest

