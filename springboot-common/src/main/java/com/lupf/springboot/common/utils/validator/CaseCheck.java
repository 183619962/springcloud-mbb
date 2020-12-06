package com.lupf.springboot.common.utils.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author LENOVO
 * @title: CaseCheck
 * @projectName springcloud-mbb
 * @description: TODO
 * @date 2020/12/2 9:01
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
//指定校验器
@Constraint(validatedBy = CaseCheckValidator.class)
public @interface CaseCheck {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    CaseMode value() default CaseMode.UPPER;
}
