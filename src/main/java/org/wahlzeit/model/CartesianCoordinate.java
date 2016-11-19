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

public class CartesianCoordinate implements Coordinate {

    // x, y, z represent a position on earths surface. The origin is the center of earth.
    private final double x;
    private final double y;
    private final double z;

    /**
     * This is the standard constructor of the CartesianCoordinate class.
     * @methodtype constructor
     * @param x
     * @param y
     * @param z
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        if (!isValidCoordinate()) {
            throw new IllegalArgumentException("CartesianCoordinate does not lie of earths surface.");
        }
    }

    /**
     * Computes the distance between this Coordinate and an other Coordinate.
     * This implementation makes use of the implementation form the SphericalCoordinate class.
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return distance between the two Coordinates
     */
    @Override
    public double getDistance(Coordinate otherCoordinate) {
        SphericalCoordinate thisAsSpherical = this.convertToSpherical();
        SphericalCoordinate otherAsSpherical = otherCoordinate.convertToSpherical();

        return thisAsSpherical.getDistance(otherAsSpherical);
    }

    /**
     * Converts the this instance to a SphericalCoordinate.
     * @return this Coordinate as SphericalCoordinate
     */
    @Override
    public SphericalCoordinate convertToSpherical() {
        double radius = Math.sqrt(x*x + y*y + z*z);
        double latitude = Math.atan2(y, x);
        double longitude =  Math.atan2(Math.sqrt( Math.pow(x,2) + Math.pow(y,2) ), z);

        return new SphericalCoordinate(Math.toDegrees(latitude), Math.toDegrees(longitude));
    }

    /**
     * Returns the prim value x.
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the prim value y.
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the prim value z.
     * @methodtype get
     */
    public double getZ() {
        return z;
    }


    /**
     * Checks if given position is located on earths surface with respect to an error value.
     * @return boolean
     */
    private boolean isValidCoordinate() {
        double lengthOfVector = Math.sqrt(x*x + y*y + z*z);

        return Math.abs(lengthOfVector - Coordinate.EARTH_RADIUS_KM) <= 1e-7;
    }
}
