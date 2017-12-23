package com.mc.uniteroute_refactor_mvp.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MCActivityFeature {
	int layout() default 0;
	int status_bar_color() default 0;
}
