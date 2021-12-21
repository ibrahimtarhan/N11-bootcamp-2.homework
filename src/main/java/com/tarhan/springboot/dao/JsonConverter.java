package com.tarhan.springboot.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("json")
public class JsonConverter implements ResponseConverter{
    @Override
    public void convert() {
        System.out.println("JSON");
    }
}
