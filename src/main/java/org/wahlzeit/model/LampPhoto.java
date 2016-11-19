package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class LampPhoto extends Photo {

    // TODO: add fields that make lamps special.
    // e.g. wastage in watt
    // bool is
    // enum Material {wood, metal, plastic}
    // enum Type {floorlamp, hanging lamp, table lamp, ...}

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