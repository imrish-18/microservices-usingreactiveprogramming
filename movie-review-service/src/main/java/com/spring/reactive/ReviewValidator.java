package com.spring.reactive;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// TODO: Auto-generated Javadoc
/**
 * The Class ReviewValidator.
 */
@Component
@Slf4j
@Primary
public class ReviewValidator implements Validator {
	
	/** The logger. */
	Logger log = LoggerFactory.getLogger(ReviewValidator.class);
    
    /**
     * Supports.
     *
     * @param clazz the clazz
     * @return true, if successful
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Review.class.equals(clazz);
    }

    /**
     * Validate.
     *
     * @param target the target
     * @param errors the errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"movieInfoId", "movieInfoId.null", "Pass a valid movieInfoId" );
        ValidationUtils.rejectIfEmpty(errors,"rating", "rating.null", "Pass a valid rating" );
        Review review = (Review) target;
        log.info("Review : {}" , review);
        if(review.getRating()!=null && review.getRating()<0.0){
            errors.rejectValue("rating", "rating.negative", "rating is negative and please pass a non-negative value");
        }

    }
}