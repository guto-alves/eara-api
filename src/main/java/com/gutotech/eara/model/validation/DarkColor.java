package com.gutotech.eara.model.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DarkColorValidator.class)
@Documented
public @interface DarkColor {

	String message() default "Escolha uma cor mais clara";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}