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
        CartesianCoordinate thisAsCartesian = otherCoordinate.convertToCartesian();
        CartesianCoordinate otherAsCartesian = otherCoordinate.convertToCartesian();

        return thisAsCartesian.getDistance(otherAsCartesian);
    }
}
