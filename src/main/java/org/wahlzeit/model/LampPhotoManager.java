package org.wahlzeit.model;

import java.util.logging.Logger;

/**
 * A lamp photo manager provides access to and manages lamp photos.
 */
public class LampPhotoManager extends PhotoManager {

    private static final Logger log = Logger.getLogger(LampPhotoManager.class.getName());

    /**
     *
     */
    protected static final LampPhotoManager instance = new LampPhotoManager();

    /**
     * This is the standard constructor of the Location class.
     * @methodtype constructor
     */
    public LampPhotoManager() {
        super();
    }



}
