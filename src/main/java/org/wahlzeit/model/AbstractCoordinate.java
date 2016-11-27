package org.wahlzeit.model;

/**
 * Created by Nils on 27/11/16.
 */
public abstract class AbstractCoordinate implements Coordinate {

    /**
     * Computes the shortest distance between this Coordinate and an other Coordinate.
     *
     * @param otherCoordinate the Coordinate to calculate the distance with.
     * @return shortest distance between the two Coordinates
     */
    @Override
    public double getDistance(Coordinate otherCoordinate) {
        CartesianCoordinate thisAsCartesian  = this.convertToCartesian();
        CartesianCoordinate otherAsCartesian = otherCoordinate.convertToCartesian();

        double distanceX = thisAsCartesian.getX() - otherAsCartesian.getX();
        double distanceY = thisAsCartesian.getY() - otherAsCartesian.getY();
        double distanceZ = thisAsCartesian.getZ() - otherAsCartesian.getZ();

        return Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2) + Math.pow(distanceZ,2));
    }
}
