package com.spring.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonControl {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson()
    {
        return new PersonV1("Sushma Parande");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson()
    {
        return new PersonV2(new Name("Sushma","Parande"));
    }

    @GetMapping(value = "/person",params ="version=1" )
    public PersonV1 getFirstVersionOfPersonRequestParameter()
    {
        return new PersonV1("Sushma Parande");
    }

    @GetMapping(value = "/person",params ="version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter()
    {
        return new PersonV2(new Name("Sushma","Parande"));
    }

    @GetMapping(value = "/person/header",headers ="X-API-VERSION=1" )
    public PersonV1 getFirstVersionOfPersonRequestHeaders()
    {
        return new PersonV1("Sushma Parande");
    }

    @GetMapping(value = "/person/header",headers ="X-API-VERSION=2" )
    public PersonV2 getSecondVersionOfPersonRequestHeaders()
    {
        return new PersonV2(new Name("Sushma","Parande"));
    }

    @GetMapping(value = "/person/accept",produces ="application/vnd.company.app-v1+json" )
    public PersonV1 getFirstVersionOfPersonAcceptHeaders()
    {
        return new PersonV1("Sushma Parande");
    }

    @GetMapping(value = "/person/accept",produces ="application/vnd.company.app-v2+json" )
    public PersonV2 getSecondVersionOfPersonAcceptHeaders()
    {
        return new PersonV2(new Name("Sushma","Parande"));
    }





}
