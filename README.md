Sample of traceability of microservices with Sleuth, Zipkin and Spring Boot - WIP
---

This is a basic sample of Sleuth, Zipkin and Spring Boot, I used the following technologies:
* Spring Boot 2.0.4.RELEASE
* Spring Cloud Sleuth 2.0.1.RELEASE
* Spring Cloud Zipkin 2.0.1.RELEASE
* Apache Maven 3.3.9

How to run?

I use docker to start Zipkin server, this will be useful to find the traces in the UI,
if you want to use it, you can copy and paste the following command in your terminal:

```
docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin
```

* UI Zipkin URL:
```
http://localhost:9411/zipkin/
```
* Clone the project and open it in your IDE
* Download dependencies with maven: `mvn clean install` at the end you should see something like this:
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] sample-traceability-microservices .................. SUCCESS [  0.990 s]
[INFO] sample-random-ms1 ................................... SUCCESS [  2.470 s]
[INFO] sample-sleuth-zipkin ............................... SUCCESS [  1.281 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
* Run the flowing main classes:
```
com.jcalvopinam.Random`ApiApplication.java
com.jcalvopinam.SampleSleuthZipkinApplication.java
```

* Open a new tab in your browser and use the following endpoint:
```
http://localhost:8081/logs_traceability/api/random_numbers
http://localhost:8081/logs_traceability/api/random_words
```

_P.D. This is still process, I will continue to implementing new functionality _