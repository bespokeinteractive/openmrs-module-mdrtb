package org.openmrs.module.mdrtb.specimen;

import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.context.Context;
import org.openmrs.module.mdrtb.MdrtbService;

/**
 * An implementaton of a MdrtbCulture.  This wraps an ObsGroup and provides access to culture
 * data within the obsgroup.
 */
public class CultureImpl extends TestImpl implements Culture {

	public CultureImpl() {
		this.mdrtbFactory = Context.getService(MdrtbService.class).getMdrtbFactory();
	}
	
	// set up a culture object, given an existing obs
	public CultureImpl(Obs culture) {
		this.mdrtbFactory = Context.getService(MdrtbService.class).getMdrtbFactory();
		
		if(culture == null || !(culture.getConcept().equals(mdrtbFactory.getConceptCultureParent()))) {
			throw new RuntimeException ("Cannot initialize culture: invalid obs used for initialization.");
		}
		
		test = culture;
	}
	
	// create a new culture object, given an existing patient
	public CultureImpl(Encounter encounter) {
		this.mdrtbFactory = Context.getService(MdrtbService.class).getMdrtbFactory();
		
		if(encounter == null) {
			throw new RuntimeException ("Cannot create culture: encounter can not be null.");
		}
		
		test = new Obs (encounter.getPatient(), mdrtbFactory.getConceptCultureParent(), encounter.getEncounterDatetime(), null);
	}
	
	@Override
	public String getTestType() {
		return "culture";
	}
	
    public Integer getColonies() {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptColonies());
    	
    	if (obs == null || obs.getValueNumeric() == null) {
    		return null;
    	}
    	else {
    		return (obs.getValueNumeric()).intValue();
    	}
    }
    
    public Concept getMethod() {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptCultureMethod());
    	
    	if (obs == null) {
    		return null;
    	}
    	else {
    		return obs.getValueCoded();
    	}
    }
    
    public Concept getOrganismType() {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptTypeOfOrganism());
    	
    	if (obs == null) {
    		return null;
    	}
    	else {
    		return obs.getValueCoded();
    	}
    }
    
    public String getOrganismTypeNonCoded() {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptTypeOfOrganismNonCoded());
    	
    	if (obs == null) {
    		return null;
    	}
    	else {
    		return obs.getValueText();
    	}
    }
    
    public Concept getResult() {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptCultureResult());
    	
    	if (obs == null) {
    		return null;
    	}
    	else {
    		return obs.getValueCoded();
    	}
    }
    
    public void setColonies(Integer colonies) {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptColonies());
    	
    	// if this obs have not been created, and there is no data to add, do nothing
		if (obs == null && colonies == null) {
			return;
		}
    	
		// if we are trying to set the obs to null, simply void the obs
		if(colonies == null) {
			obs.setVoided(true);
			obs.setVoidReason("voided by Mdr-tb module specimen tracking UI");
			return;
		}
		
    	// initialize the obs if needed
		if (obs == null) {
			obs = new Obs (test.getPerson(), mdrtbFactory.getConceptColonies(), test.getObsDatetime(), test.getLocation());
			obs.setEncounter(test.getEncounter());
			test.addGroupMember(obs);
		}
		
		// now set the value
		obs.setValueNumeric(colonies.doubleValue());
    }   

    public void setMethod(Concept method) {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptCultureMethod());
    	
    	// if this obs have not been created, and there is no data to add, do nothing
		if (obs == null && method == null) {
			return;
		}

		// if we are trying to set the obs to null, simply void the obs
		if(method == null) {
			obs.setVoided(true);
			obs.setVoidReason("voided by Mdr-tb module specimen tracking UI");
			return;
		}
		
		// initialize the obs if needed
		if (obs == null) {		
			obs = new Obs (test.getPerson(), mdrtbFactory.getConceptCultureMethod(), test.getObsDatetime(), test.getLocation());
			obs.setEncounter(test.getEncounter());
			test.addGroupMember(obs);
		}
		
		// now save the value
		obs.setValueCoded(method);
    }
    
    public void setOrganismType(Concept organismType) {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptTypeOfOrganism());
    	
    	// if this obs have not been created, and there is no data to add, do nothing
		if (obs == null && organismType == null) {
			return;
		}
    	
		// if we are trying to set the obs to null, simply void the obs
		if(organismType == null) {
			obs.setVoided(true);
			obs.setVoidReason("voided by Mdr-tb module specimen tracking UI");
			return;
		}
		
		// initialize the obs if needed
		if (obs == null) {		
			obs = new Obs (test.getPerson(), mdrtbFactory.getConceptTypeOfOrganism(), test.getObsDatetime(), test.getLocation());
			obs.setEncounter(test.getEncounter());
			test.addGroupMember(obs);
		}
		
		// now save the value
		obs.setValueCoded(organismType);
    }
    
    public void setOrganismTypeNonCoded(String organismType) {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptTypeOfOrganismNonCoded());
    	
    	// if this obs have not been created, and there is no data to add, do nothing
		if (obs == null && organismType == null) {
			return;
		}
    	
		// if we are trying to set the obs to null, simply void the obs
		if(organismType == null) {
			obs.setVoided(true);
			obs.setVoidReason("voided by Mdr-tb module specimen tracking UI");
			return;
		}
		
		// initialize the obs if needed
		if (obs == null) {		
			obs = new Obs (test.getPerson(), mdrtbFactory.getConceptTypeOfOrganismNonCoded(), test.getObsDatetime(), test.getLocation());
			obs.setEncounter(test.getEncounter());
			test.addGroupMember(obs);
		}
		
		// now save the value
		obs.setValueText(organismType);
    }

    public void setResult(Concept result) {
    	Obs obs = getObsFromObsGroup(mdrtbFactory.getConceptCultureResult());
    	
    	// if this obs have not been created, and there is no data to add, do nothing
		if (obs == null && result == null) {
			return;
		}
    	
		// if we are trying to set the obs to null, simply void the obs
		if(result == null) {
			obs.setVoided(true);
			obs.setVoidReason("voided by Mdr-tb module specimen tracking UI");
			return;
		}
		
    	// initialize the obs if we need to
		if (obs == null) {
			obs = new Obs (test.getPerson(), mdrtbFactory.getConceptCultureResult(), test.getObsDatetime(), test.getLocation());
			obs.setEncounter(test.getEncounter());
			test.addGroupMember(obs);
		}
		
		// now save the data
		obs.setValueCoded(result);
    }
}
