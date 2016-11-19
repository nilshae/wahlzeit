/*
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class Location {
    private final Coordinate coordinate;

    /**
     * This is the standard constructor of the Location class
     * @methodtype constructor
     * @param coordinate of this Location
     */
    public Location(Coordinate coordinate) {
        if(coordinate == null) {
            throw new IllegalArgumentException("coordinate can not be null.");
        }

        this.coordinate = coordinate;
    }

    /**
     * Returns the Coordinate of this Location.
     * @methodtype get
     * @return coordinate of the location
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
