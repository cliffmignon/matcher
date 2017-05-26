package com.cliff.common.plugin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date> {

    //private static final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

    private String pattern;

    public void StringToDateConverter(String pattern){
        this.pattern = pattern;
    }

    public Date convert(String s) {

//        if(StringUtils.isBlank(s)){
//            return null;
//        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        try{
            return simpleDateFormat.parse(s);
        }catch(ParseException e){
            //logger.error("转换日期异常："+e.getMessage() , e);
            throw new IllegalArgumentException("转换日期异常："+e.getMessage() , e);
        }
    }
}