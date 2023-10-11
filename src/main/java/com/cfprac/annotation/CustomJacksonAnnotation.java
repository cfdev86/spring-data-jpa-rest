package com.cfprac.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//We can combine existing annotations into a simple custom one that we can use as a shorthand
//@JacksonAnnotationsInside needs to be specified
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public @interface CustomJacksonAnnotation {
}
