Sample of traceability of microservices with Sleuth, Zipkin and Spring Boot - WIP
---

This is a basic sample of Sleuth, Zipkin and Spring Boot, I used the following technologies:
* Spring Boot 2.0.4.RELEASE
* Spring Cloud Sleuth 2.0.1.RELEASE
* Spring Cloud Zipkin 2.0.1.RELEASE
* Apache Maven 3.3.9

## How to run?

#### Zipkin
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
[INFO] sample-money-exchange .............................. SUCCESS [  2.347 s]
[INFO] sample-traceability-microservices .................. SUCCESS [  0.820 s]
[INFO] sample-random-ms1 .................................. SUCCESS [  2.394 s]
[INFO] sample-sleuth-zipkin ............................... SUCCESS [  2.035 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

* Run the following main classes:
```
com.jcalvopinam.Random`ApiApplication.java
com.jcalvopinam.SampleSleuthZipkinApplication.java
```

* Open a new tab in your browser and use the following endpoint:
```
http://localhost:8081/logs_traceability/api/random_numbers
http://localhost:8081/logs_traceability/api/random_words
http://localhost:8081/logs_traceability/api/convert-dollar-euro/{dollarsToConvert}
http://localhost:8081/logs_traceability/api/convert-dollar-euro/{eurosToConvert}
```

* Checks the trace

After running any endpoint, you must verify the record, you can see something like this:
```
INFO [Sample Sleuth,4c793299cc09c805,4c793299cc09c805,true] 3361 --- [nio-8081-exec-1] com.jcalvopinam.controller.Endpoint      : Converting to Euros
INFO [Sample Sleuth,4c793299cc09c805,4c793299cc09c805,true] 3361 --- [nio-8081-exec-1] com.jcalvopinam.service.Converter        : Converting DOLLAR to EURO: 1 DOLLAR is 0.86 EURO
INFO [Sample Sleuth,4c793299cc09c805,fdd3151da2e53bb5,true] 3361 --- [nio-8081-exec-1] c.j.service.ExchangeServiceImpl          : Converting 7.0 Dollars to Euros: 6.02
INFO [Sample Sleuth,2b0946c00839d58f,2b0946c00839d58f,true] 3361 --- [nio-8081-exec-2] com.jcalvopinam.controller.Endpoint      : Converting to Dollars
INFO [Sample Sleuth,2b0946c00839d58f,2b0946c00839d58f,true] 3361 --- [nio-8081-exec-2] com.jcalvopinam.service.Converter        : Converting EURO to DOLLAR: 1 EURO is 1.16 dollars
INFO [Sample Sleuth,2b0946c00839d58f,5061d64e686647c4,true] 3361 --- [nio-8081-exec-2] c.j.service.ExchangeServiceImpl          : Converting 75.0 Dollars to Euros: 87.0
```

Now you can copy the **spanId** and search in _Zipkin_, for example:
```
http://localhost:9411/zipkin/traces/{spanId}
http://localhost:9411/zipkin/traces/2b0946c00839d58f
```

Or you can use the field `Go to trace` in the following URL:
```
http://localhost:9411/zipkin
```