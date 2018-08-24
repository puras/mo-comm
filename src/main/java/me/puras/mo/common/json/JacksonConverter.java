package me.puras.mo.common.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:12
 */
public class JacksonConverter implements Converter {

    private final ObjectMapper mapper;

    public JacksonConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String convertToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] convertToBytes(Object object) {
        try {
            return mapper.writeValueAsBytes(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T convertToObject(String str, Type type) {
        try {
            return mapper.readValue(str, TypeFactory.defaultInstance().constructType(type));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> convertToObjects(String str, Class<T> clazz) {
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return (List<T>) mapper.readValue(str, javaType);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
