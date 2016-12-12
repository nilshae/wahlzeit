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

import static org.wahlzeit.utils.AssertionUtil.*;

public abstract class AbstractCoordinate implements Coordinate {

    /**
     * Computes the shortest distance between this Coordinate and an other Coordinate.
     *
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return shortest distance between the two Coordinates
     */
    @Override
    public double getDistance(Coordinate otherCoordinate) throws IllegalArgumentException {
        assertIsNotNull(otherCoordinate);

        double distanceX = this.cartesianX() - otherCoordinate.cartesianX();
        double distanceY = this.cartesianY() - otherCoordinate.cartesianY();
        double distanceZ = this.cartesianZ() - otherCoordinate.cartesianZ();

        double distance = Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2) + Math.pow(distanceZ,2));

        assertDistanceIsValid(distance);
        return distance;
    }

    /**
     * Test if two Coordinates have the same location with respect to an error.
     *
     * @param otherCoordinate the Coordinate to check with
     * @return if equal or not
     */
    @Override
    public boolean isEqual(Coordinate otherCoordinate) throws IllegalArgumentException{
        return (Math.abs(this.getDistance(otherCoordinate)) < 1e-7);
    }

    /**
     * @methodtype assertion
     * @param distance value to check
     */
    private void assertDistanceIsValid(double distance) throws IllegalArgumentException {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance is not valid. This means that something is wrong with the calculation.");
        }
    }

    /**
     * @methodtype assertion
     * @param value to check
     */
    protected void assertIsValidCartesian(double value) throws IllegalArgumentException {
        if (Double.isInfinite(value) || Double.isNaN(value))
        {
            throw new IllegalArgumentException("Value is not valid.");
        }
    }
}
