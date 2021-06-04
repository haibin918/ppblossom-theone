package com.meicai.ppblossom.theone.commons.annotation;

import com.meicai.ppblossom.theone.commons.enums.DatasourceEnum;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    DatasourceEnum value() default DatasourceEnum.LADDER;

    String name() default "";

}
