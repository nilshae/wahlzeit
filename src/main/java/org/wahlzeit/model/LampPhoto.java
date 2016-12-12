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

import com.googlecode.objectify.annotation.Subclass;

import static org.wahlzeit.utils.AssertionUtil.*;

@Subclass
public class LampPhoto extends Photo {

    public enum Material {METAL, WOOD, PLASTIC, OTHER}
    public enum Type {FLOOR_LAMP, HANGING_LAMP, TABLE_LAMP, STREET_LAMP, NOT_DEFINED}

    private Material material;
    private Type type;
    private boolean vintage;

    /**
     * Constructor of the LampPhoto class.
     * @methodtype constructor
     */
    public LampPhoto() throws IllegalArgumentException {
        this(PhotoId.getNextId());
    }

    /**
     * Constructor of the LampPhoto class.
     * @param myId
     * @methodtype constructor
     */
    public LampPhoto(PhotoId myId) throws IllegalArgumentException{
        this(myId, Material.OTHER, Type.NOT_DEFINED, false);
    }

    /**
     * This is the standard constructor of the LampPhoto class.
     * @param myId
     * @param myId
     * @param myId
     * @param myId
     * @methodtype constructor
     */
    public LampPhoto(PhotoId myId, Material material, Type type, boolean vintage) throws IllegalArgumentException{
        super(myId);

        assertIsNotNull(type);
        assertIsNotNull(material);
        assertIsNotNull(type);

        this.material = material;
        this.type = type;
        this.vintage = vintage;
    }

    /**
     * @methodtype get
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @methodtype set
     */
    public void setMaterial(Material material) throws IllegalArgumentException {
        assertIsNotNull(material);
        this.material = material;
    }

    /**
     * @methodtype get
     */
    public Type getType() {
        return type;
    }

    /**
     * @methodtype set
     */
    public void setType(Type type) throws IllegalArgumentException {
        assertIsNotNull(type);
        this.type = type;
    }

    /**
     * @methodtype get
     */
    public boolean isVintage() {
        return vintage;
    }

    /**
     * @methodtype set
     */
    public void setVintage(boolean vintage) throws IllegalArgumentException {
        this.vintage = vintage;
    }
}