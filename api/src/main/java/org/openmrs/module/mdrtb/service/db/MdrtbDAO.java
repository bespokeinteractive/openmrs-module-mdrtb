package org.openmrs.module.mdrtb.service.db;

import java.util.List;

import org.openmrs.Location;
import org.openmrs.User;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.mdrtb.model.UserLocation;

public interface MdrtbDAO {

    /**
     * @return all Locations which have non-voided Patient Programs associated with them
     */
    public List<Location> getLocationsWithAnyProgramEnrollments() throws DAOException;

    public List<UserLocation> getUserLocations(User user);
}
