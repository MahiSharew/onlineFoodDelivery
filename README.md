# Online food Delivery System 
Online food Delivery System  have  4 major microservices that work and integrate together.
##### Order Service 
process all  customer orders such as customer order food by choosing a different menu, quantity; get valid
payment information from payment Microservices  and Send Email about order information to the customer 
##### Member Management Service
register user, user information, user credit card information, user delivery address information 
##### Restaurant Management Service
handle all the restaurant and menu information such as registering restaurant information, get all restaurant and food information  find Restaurant by restaurant ID
##### Payment Management Service 
using sample data, check if using credit card information is valid or not and   send the result through the message queue  

##### High level  design 
![High level solution design](https://github.com/MahiSharew/onlineFoodDelivery/blob/master/img/High-LevelDesignDiagram.png)
> High level solution design 



###### Order microservice to Restaurant microservice communication using AMQP and RabbitMQ
![AMQP and RabbitMQ](https://github.com/MahiSharew/onlineFoodDelivery/blob/master/img/message.jpg)
> AMQP and RabbitMQ
---


## Technologies used
<details><summary>Use the technologies for restaurant Microservice</summary>
<p>
 * Java Persistence Query Language (JPQL)
 * Used fetch type Lazy which lazy and fetching strategy subselect SUBSELECT
(between restaurant entity, food menu entity )
 * Aspect-oriented programming for each rest call (@before and @AfterReturning,
 * logging aspect on file, rest, service and Dao package )
 * Messaging AMQP and Rabbitmq
 * Spring Rest Global exception handling (@ContollerAdvice)
 * Hibernate Validator
 * Jackson (data binding passed data that Rest Controller to Java POJO )
</p>
</details>
<details><summary>Use the technologies for Order Microservice</summary>
<p>
* Email
* Java Persistence Query Language (JPQL)
* Used fetch type Lazy which lazy and fetching strategy subselect SUBSELECT (
restaurant entity, food menu entity )
* Aspect-oriented programming for each rest call (@before and @AfterReturning,
logging aspect on file, rest, service and Dao package )
* Messaging AMQP and Rabbitmq
* Spring Rest Global exception handling (@ContollerAdvice)
* Hibernate Validator
* Jackson (data binding passed data that Rest Controller to Java POJO )
* Email
</p>
</details>
