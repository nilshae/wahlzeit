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

public class SphericalCoordinate implements Coordinate {
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
        if(latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("latitude is not between -90° and 90°");
        }
        if(longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("longitude in not between -180° and 180°");
        }

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = Math.abs(radius);
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

    /**
     * Computes the distance between this Coordinate and an other Coordinate.
     * The implementation follows <a href="http://[...]">https://www.wikiwand.com/en/Haversine_formula#/The_haversine_formula</a>
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return distance between the two Coordinates
     */
    @Override
    public double getDistance(Coordinate otherCoordinate) {
        if(otherCoordinate == null) {
            throw new IllegalArgumentException("otherCoordinate can not be null.");
        }

        SphericalCoordinate otherSphericalCoordinate = otherCoordinate.convertToSpherical();

        double deltaLatitude = Math.toRadians(latitude - otherSphericalCoordinate.getLatitude());
        double deltaLongitude = Math.toRadians(longitude - otherSphericalCoordinate.getLongitude());
        double firstLatitudeInRad = Math.toRadians(latitude);
        double secondLatitudeInRad = Math.toRadians(otherSphericalCoordinate.getLatitude());

        double haversineCentralAngle = haversine(deltaLatitude) + Math.cos(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * haversine(deltaLongitude);
        return 2 * EARTH_RADIUS_KM * Math.asin(Math.sqrt(haversineCentralAngle));
    }

    /**
     * Converts the instance to a SphericalCoordinate. This implementation exits only to full fill the Coordinate interface.
     * @return this SphericalCoordinate
     */
    @Override
    public SphericalCoordinate convertToSpherical() {
        return this;
    }

    /**
     * Converts the this instance to a CartesianCoordinate.
     * @return this Coordinate as CartesianCoordinate
     */
    @Override
    public CartesianCoordinate convertToCartesian() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());

        double x = radius * Math.cos(latitudeRadian) * Math.cos(longitudeRadian);
        double y = radius * Math.cos(latitudeRadian) * Math.sin(longitudeRadian);
        double z = radius * Math.sin(latitudeRadian);

        return new CartesianCoordinate(x, y, z);
    }

    /**
     * Computes the haversine for a given angle in radians.
     * The implementation follows https://www.wikiwand.com/en/Haversine_formula#/The_haversine_formula
     * @param angleInRand the angle in radians
     * @return the haversine for the given angle.
     */
    private double haversine(double angleInRand) {
        return (1 - Math.cos(angleInRand))/ 2;
    }
}
