package com.cfprac.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Custom deserializer for LocalDateTime
public class CustomLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

    public CustomLocalDateTimeDeserializer(){
        this(null);
    }

    protected CustomLocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String dateTime = jsonParser.getText();
        return LocalDateTime.parse(dateTime, formatter);
    }
}
