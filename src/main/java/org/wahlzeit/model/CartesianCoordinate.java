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

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;

@PatternInstance(
        patternName = "ValueObject",
        participants = {"ValueObject"},
        role = "ValueObject"
)
public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    private static final HashMap<CartesianCoordinate, CartesianCoordinate> instances = new HashMap<>();

    /**
     * This is the standard constructor of the CartesianCoordinate class.
     * @methodtype constructor
     * @param x
     * @param y
     * @param z
     */
    private CartesianCoordinate(double x, double y, double z) {
        assertIsValidCartesian(x);
        assertIsValidCartesian(y);
        assertIsValidCartesian(z);

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the CartesianCoordinate with the values x, y and z. Creates a new one, if
     * there is non existing.
     * @param x
     * @param y
     * @param z
     * @return CartesianCoordinate
     */
    public static CartesianCoordinate getInstance(double x, double y, double z) {
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);

        synchronized (instances) {
            if (!instances.containsValue(coordinate)) {
                instances.put(coordinate, coordinate);
            }
            return instances.get(coordinate);
        }
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

    @Override
    public double cartesianX() {
        return getX();
    }

    @Override
    public double cartesianY() {
        return getY();
    }

    @Override
    public double cartesianZ() {
        return getZ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartesianCoordinate that = (CartesianCoordinate) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        return Double.compare(that.z, z) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
