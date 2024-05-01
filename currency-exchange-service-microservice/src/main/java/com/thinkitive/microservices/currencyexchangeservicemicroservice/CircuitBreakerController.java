package com.thinkitive.microservices.currencyexchangeservicemicroservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

@RestController
public class CircuitBreakerController {
    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardcodedResponse")

//    @CircuitBreaker(name = "sample-api",fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "sample-api")
    //10s => 10000 calls to the sample api
    public String sampleApi()
    {
        logger.info("Sample Api call received");
//        ResponseEntity<String> forEntity=new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//                String.class);
//        return forEntity.getBody();
        return "Sample-api";
    }
    public String hardcodedResponse(Exception ex)
    {
        return "fallback-response";
    }

}