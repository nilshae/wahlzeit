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

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.wahlzeit.utils.AssertionUtil.assertIsNotNull;

@Serialize
@Subclass
public class LampType extends DataObject {
    public enum Material {METAL, WOOD, PLASTIC, UNDEFINED}
    public enum Kind {FLOOR_LAMP, HANGING_LAMP, TABLE_LAMP, STREET_LAMP, UNDEFINED}

    protected LampType superType = null;
    protected Set<LampType> subTypes = new HashSet<>();

    private final String modelName;
    private final Material material;
    private final Kind kind;
    private final boolean vintage;

    /**
     * @methodtype constructor
     */
    public LampType(String modelName, Material material, Kind kind, boolean vintage) {
        this.modelName = modelName;
        this.material = material;
        this.kind = kind;
        this.vintage = vintage;
    }

    /**
     * Creates a Lamp instance of this LampType.
     * @return Lamp
     */
    public Lamp createInstance() {
        return new Lamp(this);
    }

    /**
     * Add a sub type to the current type
     * @methodtype command
     */
    public void addSubType(LampType lampType) {
        assertIsNotNull(lampType);

        lampType.setSuperType(this);
        subTypes.add(lampType);
    }

    /**
     * Check if a Lamp instance has the current type.
     * @methodtype query
     */
    public boolean hasInstance(Lamp lamp) {
        assertIsNotNull(lamp);

        if (lamp.getType() == this) {
            return true;
        }

        for (LampType type : subTypes) {
            if (type.hasInstance(lamp)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if this type is a sub type of a given type.
     * @methodtype query
     */
    public boolean isSubTypeOf(LampType lampType) {
        assertIsNotNull(lampType);
        Iterator<LampType> it = lampType.getSubTypeIterator();

        while (it.hasNext()){
            if (it.next() == this) {
                return true;
            }
        }

        return false;
    }

    /**
     * @methodtype get
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @methodtype get
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @methodtype get
     */
    public Kind getKind() {
        return kind;
    }

    /**
     * @methodtype get
     */
    public boolean isVintage() {
        return vintage;
    }

    /**
     * @methodtype get
     */
    public Iterator<LampType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * @methodtype get
     */
    public LampType getSuperType() {
        return superType;
    }

    /**
     * @methodtype set
     */
    public void setSuperType(LampType superType) {
        this.superType = superType;
    }
}
