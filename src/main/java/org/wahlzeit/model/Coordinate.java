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

public class Coordinate {
    public static final double EARTH_RADIUS_KM = 6371;
    private final double latitude;
    private final double longitude;

    /**
     * @methodtype constructor
     */
    public Coordinate() {
        this.latitude = 0;
        this.longitude = 0;
    }

    /**
     * This is the standard constructor of the Coordinate class.
     * @methodtype constructor
     * @param latitude in degree
     * @param longitude in degree
     */
    public Coordinate(double latitude, double longitude) {
        if(latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("latitude is not between -90° and 90°");
        }
        if(longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("longitude in not between -180° and 180°");
        }

        this.latitude = latitude;
        this.longitude = longitude;
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
     * Computes the distance between this Coordinate and an other Coordinate.
     * The implementation follows <a href="http://[...]">https://www.wikiwand.com/en/Haversine_formula#/The_haversine_formula</a>
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return distance between the two Coordinates
     */
    public double getDistance(Coordinate otherCoordinate) {
        if(otherCoordinate == null) {
            throw new IllegalArgumentException("otherCoordinate can not be null.");
        }

        double deltaLatitude = Math.toRadians(latitude - otherCoordinate.getLatitude());
        double deltaLongitude = Math.toRadians(longitude - otherCoordinate.getLongitude());
        double firstLatitudeInRad = Math.toRadians(latitude);
        double secondLatitudeInRad = Math.toRadians(otherCoordinate.getLatitude());

        double haversineCentralAngle = haversine(deltaLatitude) + Math.cos(firstLatitudeInRad) * Math.cos(secondLatitudeInRad) * haversine(deltaLongitude);
        return 2 * EARTH_RADIUS_KM * Math.asin(Math.sqrt(haversineCentralAngle));
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
