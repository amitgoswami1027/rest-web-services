package com.amitgoswami.rest.webservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{
    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean()
    {
        SomeBean someBean = new SomeBean("value1", "value2", "value2" );
        //SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        //FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter" , filter);

        //MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        //mapping.setFilters(filters);
        return someBean;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBean()
    {
        return Arrays.asList(new SomeBean("value1", "value2", "value3" ),
                new SomeBean("value12", "value22", "value32"));
    }

}
