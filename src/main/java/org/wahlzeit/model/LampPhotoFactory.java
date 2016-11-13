package org.wahlzeit.model;

/**
 * Factory for creating lamp photos and related objects.
 */
public class LampPhotoFactory extends PhotoFactory {

    // initialize the singleton instance.
    static { instance = new LampPhotoFactory(); }

    /**
     * Creates a new photo
     *
     * @methodtype factory
     */
    public Photo createPhoto() {
        return new LampPhoto();
    }

    /**
     * Creates a new photo with the specified id
     *
     * @methodtype factory
     */
    public Photo createPhoto(PhotoId myId) {
        return new LampPhoto(myId);
    }
}
