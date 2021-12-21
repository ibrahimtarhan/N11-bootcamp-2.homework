package com.tarhan.springboot.entityService;

import com.tarhan.springboot.dao.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
//    @Autowired
//    private ResponseConverter responseConverter;

    @Autowired
    @Qualifier("json")
    private ResponseConverter jsonresponseConverter;

    //public ConverterService(ResponseConverter responseConverter) {
      //  this.responseConverter = responseConverter;
    //}

    public void convertResponse(){
        jsonresponseConverter.convert();
    }
}
