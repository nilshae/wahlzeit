package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class LampPhoto extends Photo {

    public enum Material {METAL, WOOD, PLASTIC, OTHER}
    public enum Type {FLOOR_LAMP, HANGING_LAMP, TABLE_LAMP, STREET_LAMP}

    Material material;
    Type type;
    int consumptionInKwh;

    /**
     * This is the standard constructor of the LampPhoto class.
     * @methodtype constructor
     */
    public LampPhoto() {
        super();
    }

    /**
     * Constructor of the LampPhoto class.
     * @param myId
     * @methodtype constructor
     */
    public LampPhoto(PhotoId myId) {
        super(myId);
    }
}