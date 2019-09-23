package com.amitgoswami.rest.webservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Different ways of Versioning
// Mapping different URIS - /v1/person ; /v2/person
// VERSIONING - "NO PERFECT STRATEGY"
// 1. Media Type Versioning ( "content negotiation" or "accept headers)" --> GitHub
// 2. Headers Versioning --> Microsoft
// 3. URI Versioning --> Twitter
// 4. Request Param Versioning --> Amazon
// Factors
//   - URI Pollution
//   - Misuse of Headers.
//   - caching
//   - Can we execute the request on the browser.
//   - API Documentation
@RestController
public class VersioningController
{
    //URI VERSIONING
    @GetMapping("/v1/person")
    public PersonV1 personV1()
    {
        return new PersonV1("Amit Goswami");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2()
    {
        return new PersonV2(new Name("Sumit", "Goswami"));
    }

    //PARAM VERSIONING
    // /person/param/version=1
    // /person/param/version=2
    @GetMapping(value = "person/param" , params ="version = 1")
    public PersonV1 paramV1()
    {
        return new PersonV1("Amit Goswami");
    }

    @GetMapping(value = "person/param" , params ="version = 2")
    public PersonV2 paramV2()
    {
        return new PersonV2(new Name("Sumit", "Goswami"));
    }

    //HEADER VERSIONING
    // MISUSE OF HTTP HEADEARS, HTTP HEADERS ARE NEVER DESIGNED FOR VERSIONING
    // /person/header        X-API-VERSION=1 or X-API=VERSION=2
    @GetMapping(value = "person/header" , headers ="X-API-VERSION=1")
    public PersonV1 headerV1()
    {
        return new PersonV1("Amit Goswami");
    }

    @GetMapping(value = "person/header" , headers ="X-API-VERSION=2")
    public PersonV2 headerV2()
    {
        return new PersonV2(new Name("Sumit", "Goswami"));
    }

    //MEDIA TYPE VERSIONING
    // /person/produces    Accept = "application/vnd.company.app-v1+json"
    @GetMapping(value = "person/produces" , produces ="application/vnd.company.app-v1+json")
    public PersonV1 producesV1()
    {
        return new PersonV1("Amit Goswami");
    }

    @GetMapping(value = "person/produces" , produces ="application/vnd.company.app-v2+json")
    public PersonV2 producesV2()
    {
        return new PersonV2(new Name("Sumit", "Goswami"));
    }

}
