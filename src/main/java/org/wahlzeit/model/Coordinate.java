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

public interface Coordinate {
    /**
     * Computes the shortest distance between this Coordinate and an other Coordinate.
     *
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return shortest distance between the two Coordinates
     */
    double getDistance(Coordinate otherCoordinate);

    /**
     * Test if two Coordinates have the same location with respect to an error.
     *
     * @param otherCoordinate the Coordinate to check with
     * @return true if equal or false if not
     */
    boolean isEqual(Coordinate otherCoordinate);
}