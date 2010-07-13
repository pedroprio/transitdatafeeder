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
package org.ideaproject.action.entityhome;

import org.ideaproject.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

/**
 * Seam EntityHome for RouteTypes
 * @author dirk
 * @see org.jboss.seam.framework.EntityHome
 */
@Name("routeTypeHome")
public class RouteTypeHome extends EntityHome<RouteType> {

	private static final long serialVersionUID = 1L;

	/**
	 * Sets the current route type by ID; side effect updates the
	 * instance.
	 * @param id the bike option ID
	 */
	public void setRouteTypeRouteTypeId(Integer id) {
		setId(id);
	}

	/**
	 * @return the ID of the current route type.
	 */
	public Integer getRouteTypeRouteTypeId() {
		return (Integer) getId();
	}

	/*
	 * (non-Javadoc)
	 * @see org.jboss.seam.framework.Home#createInstance()
	 */
	@Override
	protected RouteType createInstance() {
		RouteType routeType = new RouteType();
		return routeType;
	}

	/**
	 * Loads the current route type.
	 */
	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	/**
	 * "Wires" the current instance
	 */
	public void wire() {
		getInstance();
	}

	/**
	 * @return whether or not the current route type is "wired"
	 * @see #wire()
	 */
	public boolean isWired() {
		return true;
	}

	/**
	 * Gets the currently defined instance; may return null if the ID for this
	 * EntityHome is not supplied.
	 * @return the currently-defined instance, or null if none is defined.
	 */
	public RouteType getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
