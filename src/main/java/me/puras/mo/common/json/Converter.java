package me.puras.mo.common.json;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:11
 */
public interface Converter {
    String convertToString(Object object);
    byte[] convertToBytes(Object object);
    <T> T convertToObject(String str, Type type);
    <T> List<T> convertToObjects(String str, Class<T> clazz);
}
