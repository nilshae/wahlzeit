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

import static org.wahlzeit.utils.AssertionUtil.*;

/**
 * Factory for creating lamp photos and related objects.
 */
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "AbstractFactory",
                "AbstractProduct",
                "ConcreteFactory",
                "ConcreteProduct"
        },
        role = "ConcreteFactory"
)
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
    /// the createPhoto method of LampPhotoFactory
    public Photo createPhoto(PhotoId myId) {
        assertIsNotNull(myId);
        ///(4) the creation of a new LampPhoto object by calling the constructor of LampPhoto with the new keyword
        return new LampPhoto(myId);
    }
}
