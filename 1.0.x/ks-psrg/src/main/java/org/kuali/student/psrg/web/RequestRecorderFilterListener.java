package org.kuali.student.psrg.web;

/**
 * Implementations of this interface will get notified when a servlet filter
 * event occurs
 */
public interface RequestRecorderFilterListener {
	public void onBeforeDoFilter(HttpServletFilterContext context);

	public void onAfterDoFilter(HttpServletFilterContext context);
}