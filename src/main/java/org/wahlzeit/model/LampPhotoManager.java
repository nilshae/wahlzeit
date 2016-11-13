package org.wahlzeit.model;

/**
 * A lamp photo manager provides access to and manages lamp photos.
 */
public class LampPhotoManager extends PhotoManager {

    // initialize the singleton instance.
    static { instance = new LampPhotoManager(); }
}
