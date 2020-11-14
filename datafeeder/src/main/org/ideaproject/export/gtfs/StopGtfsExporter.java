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
package org.ideaproject.export.gtfs;

import java.io.IOException;
import java.io.OutputStream;

import org.ideaproject.Constants;
import org.ideaproject.model.Stop;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;

/**
 * @author dirk
 *
 */
public class StopGtfsExporter extends AbstractGtfsExporter<Stop> {
	private static final Object BUFFER_LOCK = new Object();
	private static final StringBuffer BUFFER = new StringBuffer(255);
	@Logger
	private Log logger;

	public void export(Stop toExport, OutputStream outStream)
			throws IOException {
		//stopId,stopName,stopDesc,stopLat,stopLon,zone.zoneId,stopUrl,locationType,parentStation
		BUFFER.delete(0, BUFFER.length());
		BUFFER.append(toExport.getStopId());
		BUFFER.append(SEPARATOR);
		BUFFER.append(stringifyInput(toExport.getStopName()));
		BUFFER.append(SEPARATOR);
		BUFFER.append(stringifyInput(toExport.getStopDesc()));
		BUFFER.append(SEPARATOR);
		BUFFER.append(toExport.getStopLat());
		BUFFER.append(SEPARATOR);
		BUFFER.append(toExport.getStopLon());
		BUFFER.append(SEPARATOR);
		BUFFER.append(toExport.getZone() != null ? toExport.getZone().getZoneId() : Constants.EMPTY);
		BUFFER.append(SEPARATOR);
		BUFFER.append(toExport.getStopUrl() != null ? toExport.getStopUrl() : Constants.EMPTY);
		BUFFER.append(SEPARATOR);
		BUFFER.append(Constants.STOP_LOCATION_TYPE_ID);
		BUFFER.append(SEPARATOR);
		BUFFER.append(toExport.getParentStation() != null ? toExport.getParentStation().getStopId() : Constants.EMPTY);
		BUFFER.append(LINE_SEPARATOR);
		outStream.write(BUFFER.toString().getBytes("UTF-8"));
	}

	final Class<Stop> getSupportedClass() {
		return Stop.class;
	}

}
