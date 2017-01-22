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

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;

import java.util.*;
import java.util.logging.Logger;

import static org.wahlzeit.utils.AssertionUtil.assertIsNotEmptyString;
import static org.wahlzeit.utils.AssertionUtil.assertIsNotNull;

public class LampManager extends ObjectManager {
    protected static LampManager instance = new LampManager();
    protected Map<Integer, Lamp> lamps = new HashMap<>();

    private static final Logger log = Logger.getLogger(LampManager.class.getName());

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
     * @methodtype command
     */
    public void init() {
        loadLamps();
    }

    /**
     * @methodtype factory method
     */
    /// the createLamp method of LampManager
    public Lamp createLamp(String modelName, LampType.Material material, LampType.Kind kind, boolean vintage) {
        assertIsValidModelName(modelName);
        assertIsNotNull(material);
        assertIsNotNull(kind);

        LampType lampType = new LampType(modelName, material, kind, vintage);
        ///[1] LampManager calls the createInstance method of the LampType
        Lamp lampInstance = lampType.createInstance();
        updateObject(lampInstance);
        doAddLamp(lampInstance);

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
     * @methodtype command
     *
     * Load all persisted lamps. Executed when Wahlzeit is restarted.
     */
    public void loadLamps() {
        Collection<Lamp> existingLamps = ObjectifyService.run(new Work<Collection<Lamp>>() {
            @Override
            public Collection<Lamp> run() {
                Collection<Lamp> existingLamps = new ArrayList<>();
                readObjects(existingLamps, Lamp.class);
                return existingLamps;
            }
        });

        for(Lamp lamp : existingLamps) {
            lamps.put(lamp.getId(), lamp);
        }

        log.info(LogBuilder.createSystemMessage().addMessage("All lamps loaded.").toString());
    }

    /**
     * @methodtype assertion
     */
    private void assertIsValidModelName(String modelName) {
        assertIsNotEmptyString(modelName);
        // if (lampTypes.containsKey(modelName)) {
        //     throw new IllegalArgumentException("ArchitectureType with name " + modelName + " already exists");
        // }
    }

    /**
     * @methodtype assertion
     */
    protected void assertIsNewLamp(Integer id) {
        if (lamps.containsKey(id)) {
            throw new IllegalStateException("Lamp already exists!");
        }
    }
}
