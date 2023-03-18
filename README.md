## Application Overview ##

This is a weather forecast application which uses wetter.com rapid api for show hourly and summary weather report according to location. It is developed using Spring Boot framework
I have created controller, service, dto and exception module in it. 

## Future Improvement ##

Write now I am not caching location data but we can use caching with expiration to avoid repeated api call 
for same location. 
Also Weather interface is created with the idea that if more apis from different weather forecasting organisation need to be accomadated it can be done easily


## Running the server locally ##
To be able to run this Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.

```
maven package
```
or you can also use

```
mvn install
```

or you can also use 

```
./mvnw package
```

To run the Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

```
java -jar target/weather-0.0.1-SNAPSHOT.jar
```

You can also use Maven plugin to run the app. Use the below example to run your Spring Boot app with Maven plugin :

```
mvn spring-boot:run
```





## Api endpoints are as follows  ##
``````
http://localhost:8080/getweather/wettercom?forcast_type=summary&location_name=Berlin (HTTP:GET)
http://localhost:8080/getweather/wettercom?forcast_type=hourly&location_name=Berlin (HTTP:GET)

``````

## Header Authentication Required ##

```
You need to pass client_id and client_secret header like below
client_id = user
client_secret = topsecret

However you can change this value in application.properties file
```


