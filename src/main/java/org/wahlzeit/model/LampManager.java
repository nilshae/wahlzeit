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

import org.wahlzeit.services.ObjectManager;

import java.util.*;

import static org.wahlzeit.utils.AssertionUtil.assertIsNotEmptyString;
import static org.wahlzeit.utils.AssertionUtil.assertIsNotNull;

public class LampManager extends ObjectManager {
    protected static LampManager instance = new LampManager();
    protected Map<Integer, Lamp> lamps = new HashMap<>();

    /**
     * @methodtype constructor
     */
    public static final LampManager getInstance() {
        return instance;
    }

    /**
     * @methodtype get
     */
    public Map<Integer, Lamp> getLamps() {
        return lamps;
    }

    /**
     * @methodtype factory method
     */
    public Lamp createLamp(String modelName, LampType.Material material, LampType.Kind kind, boolean vintage) {
        assertIsNotEmptyString(modelName);
        assertIsNotNull(material);
        assertIsNotNull(kind);

        LampType lampType = new LampType(modelName, material, kind, vintage);
        Lamp lampInstance = lampType.createInstance();
        lamps.put(lampInstance.getId(), lampInstance);
        return lampInstance;
    }

    /**
     * @methodtype command
     */
    public void addLamp(Lamp lamp) {
        Integer id = lamp.getId();
        assertIsNewLamp(id);
        doAddLamp(lamp);

        GlobalsManager.getInstance().saveGlobals();
    }

    /**
     * @methodtype command
     * @methodproperties primitive
     */
    protected void doAddLamp(Lamp lamp) {
        lamps.put(lamp.getId(), lamp);
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNewLamp(Integer id) {
        // FIXME: hasLamp has to be implemented (this will be done when the ID problem is solved)
        // if (hasLamp(id)) {
        //     throw new IllegalStateException("Lamp already exists!");
        // }
    }
}
