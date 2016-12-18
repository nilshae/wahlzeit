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

public class SphericalCoordinate extends AbstractCoordinate {
    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * This is the standard constructor of the SphericalCoordinate class.
     * @methodtype constructor
     * @param latitude in degree
     * @param longitude in degree
     * @param radius in km
     */
    public SphericalCoordinate(double latitude, double longitude, double radius) {
        assertLatitudeIsValid(latitude);
        assertLongitudeIsValid(longitude);
        assertRadiusIsValid(radius);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    /**
     * Returns the latitude.
     * @methodtype get
     * @return latitude in degree
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Returns the longitude.
     * @methodtype get
     * @return longitude in degree
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Returns the radius.
     * @methodtype get
     * @return radius in km
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public double cartesianX() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());
        double xValue = radius * Math.cos(latitudeRadian) * Math.cos(longitudeRadian);

        assertIsValidCartesian(xValue);
        return xValue;
    }

    @Override
    public double cartesianY() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());
        double yValue = radius * Math.cos(latitudeRadian) * Math.sin(longitudeRadian);
        
        assertIsValidCartesian(yValue);
        return yValue;
    }

    @Override
    public double cartesianZ() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double zValue = radius * Math.sin(latitudeRadian);

        assertIsValidCartesian(zValue);
        return zValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphericalCoordinate that = (SphericalCoordinate) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        return Double.compare(that.radius, radius) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * @methodtype assertion
     * @param latitude value to check
     */
    private void assertLatitudeIsValid(double latitude) {
        if(latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("latitude is not between -90° and 90°");
        }
    }

    /**
     * @methodtype assertion
     * @param longitude value to check
     */
    private void assertLongitudeIsValid(double longitude) {
        if(longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("longitude in not between -180° and 180°");
        }
    }

    /**
     * @methodtype assertion
     * @param radius value to check
     */
    private void assertRadiusIsValid(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius is negative.");
        }
    }
}
