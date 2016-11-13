package org.wahlzeit.model;

import java.util.logging.Logger;

public class LampPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(LampPhotoFactory.class.getName());

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static LampPhotoFactory instance = null;

    /**
     * This is the standard constructor of the LampPhotoFactory class.
     * @methodtype constructor
     */
    public LampPhotoFactory() {
        super();
    }


}
