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

    @Override
    protected double getCartesianX() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());
        return radius * Math.cos(latitudeRadian) * Math.cos(longitudeRadian);
    }

    @Override
    protected double getCartesianY() {
        double latitudeRadian = Math.toRadians(getLatitude());
        double longitudeRadian = Math.toRadians(getLongitude());
        return radius * Math.cos(latitudeRadian) * Math.sin(longitudeRadian);
    }

    @Override
    protected double getCartesianZ() {
        double latitudeRadian = Math.toRadians(getLatitude());
        return radius * Math.sin(latitudeRadian);
    }
}
