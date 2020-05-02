package edu.mum.dream.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
 
@SuppressWarnings("deprecation")
@NotEmpty( )
@Size
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface EmptyOrSize {
	String message() default "Validation for an optional numeric field failed.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {  };
	
	@OverridesAttribute(constraint=Size.class, name="min")
    int min() default 10;

    @OverridesAttribute(constraint=Size.class, name="max")
    int max() default 15;
    
	
}
