/**
 *  Copyright 2010 SingleMind Consulting, Inc. (http://singlemindconsulting.com)
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */
package org.ideaproject.action.entityquery;

import org.ideaproject.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("calendarDateExceptionList")
public class CalendarDateExceptionList
		extends
			EntityQuery<CalendarDateException> {

	private static final String EJBQL = "select calendarDateException from CalendarDateException calendarDateException";

	private static final String[] RESTRICTIONS = {};

	private CalendarDateException calendarDateException = new CalendarDateException();

	public CalendarDateExceptionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public CalendarDateException getCalendarDateExceptions() {
		return calendarDateException;
	}
}
