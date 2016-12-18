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

public class CartesianCoordinate extends AbstractCoordinate {

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
    public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException{
        assertIsValidCartesian(x);
        assertIsValidCartesian(y);
        assertIsValidCartesian(z);

        this.x = x;
        this.y = y;
        this.z = z;
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
}
