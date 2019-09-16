package com.lqm.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.lqm.util.DateTimeUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Jackson配置类
 */

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        //对象的所有字段全部列入
//        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //取消默认转换timestamps形式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //忽略空Bean转json的错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));
        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        //null 转为 " "
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
//                    throws IOException {
//                jsonGenerator.writeString("");
//            }
//        });
        return objectMapper;
    }
//
//
//
//    @Bean
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        //设置日期格式
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //对象的所有字段全部列入
//        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
//        //取消默认转换timestamps形式
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
//        //忽略空Bean转json的错误
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
//        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
//        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));
//        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//
//        //null 转为 " "
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
//                    throws IOException {
//                jsonGenerator.writeString("");
//            }
//        });
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        //设置中文编码格式
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//        return mappingJackson2HttpMessageConverter;
//    }


}
