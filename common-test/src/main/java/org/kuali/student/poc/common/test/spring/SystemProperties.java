package org.kuali.student.poc.common.test.spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SystemProperties {
	public Property[] properties();
}
