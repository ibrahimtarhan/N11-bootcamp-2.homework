package com.tarhan.springboot.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("xml")
public class XMLConverter implements ResponseConverter{
    @Override
    public void convert() {
        System.out.println("XML");
    }
}
