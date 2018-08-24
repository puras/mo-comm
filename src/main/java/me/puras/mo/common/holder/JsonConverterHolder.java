package me.puras.mo.common.holder;


import me.puras.mo.common.json.Converter;
import me.puras.mo.common.json.JacksonConverter;

/**
 * @author puras <he@puras.me>
 * @since 16/1/25  下午10:13
 */
public class JsonConverterHolder {
    private static final JsonConverterHolder instance = new JsonConverterHolder();
    private final Converter converter;

    private JsonConverterHolder() {
        converter = new JacksonConverter(ObjectMapperHolder.getInstance().getMapper());
    }

    public static JsonConverterHolder getInstance() {
        return instance;
    }

    public Converter getConverter() {
        return converter;
    }
}
