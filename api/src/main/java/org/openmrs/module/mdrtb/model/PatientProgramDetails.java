package org.openmrs.module.mdrtb.model;

import org.openmrs.Concept;
import org.openmrs.PatientProgram;
import org.openmrs.ProgramWorkflowState;
import org.openmrs.api.context.Context;
import org.openmrs.module.mdrtb.MdrtbPatient;
import org.openmrs.module.mdrtb.model.LocationFacilities;
import org.openmrs.module.mdrtb.program.MdrtbPatientProgram;
import org.openmrs.module.mdrtb.service.MdrtbService;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dennis Henry
 * Created on 1/14/2017.
 */
public class PatientProgramDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private ProgramWorkflowState patientType;
    private ProgramWorkflowState patientCategory;
    private PatientProgram patientProgram;
    private PatientProgram referringProgram;
    private PatientProgramRegimen regimen;
    private LocationFacilities facility;
    private String tbmuNumber;
    private String labNumber;
    private String secondLineNumber = "N/A";
    private Date secondLineDate;
    private String description;
    private String daamin;
    private String daaminContacts;
    private Concept diseaseSite;
    private Concept confirmationSite;
    private Concept sputumResults;
    private Concept initialStatus;
    private Concept currentStatus;
    private Concept cptStarted;
    private Concept artStarted;
    private Concept outcome;
    private Boolean transferred;

    //Non-Persistent Properties
    private String weight = "N/A";
    private String height = "N/A";

    // Start of Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PatientProgram getPatientProgram() {
        return patientProgram;
    }

    public void setPatientProgram(PatientProgram patientProgram) {
        this.patientProgram = patientProgram;
    }

    public String getTbmuNumber() {
        return tbmuNumber;
    }

    public void setTbmuNumber(String tbmuNumber) {
        this.tbmuNumber = tbmuNumber;
    }

    public String getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(String labNumber) {
        this.labNumber = labNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientProgram getReferringProgram() {
        return referringProgram;
    }

    public void setReferringProgram(PatientProgram referringProgram) {
        this.referringProgram = referringProgram;
    }

    public String getDaamin() {
        return daamin;
    }

    public void setDaamin(String daamin) {
        this.daamin = daamin;
    }

    public String getDaaminContacts() {
        return daaminContacts;
    }

    public void setDaaminContacts(String daaminContacts) {
        this.daaminContacts = daaminContacts;
    }

    public Concept getDiseaseSite() {
        return diseaseSite;
    }

    public void setDiseaseSite(Concept diseaseSite) {
        this.diseaseSite = diseaseSite;
    }

    public Concept getSputumResults() {
        return sputumResults;
    }

    public void setSputumResults(Concept sputumResults) {
        this.sputumResults = sputumResults;
    }

    public ProgramWorkflowState getPatientType() {
        return patientType;
    }

    public void setPatientType(ProgramWorkflowState patientType) {
        this.patientType = patientType;
    }

    public ProgramWorkflowState getPatientCategory() {
        return patientCategory;
    }

    public void setPatientCategory(ProgramWorkflowState patientCategory) {
        this.patientCategory = patientCategory;
    }

    public Concept getInitialStatus() {
        return initialStatus;
    }

    public void setInitialStatus(Concept initialStatus) {
        this.initialStatus = initialStatus;
    }

    public Concept getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Concept currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Concept getCptStarted() {
        return cptStarted;
    }

    public void setCptStarted(Concept cptStarted) {
        this.cptStarted = cptStarted;
    }

    public Concept getArtStarted() {
        return artStarted;
    }

    public void setArtStarted(Concept artStarted) {
        this.artStarted = artStarted;
    }

    public LocationFacilities getFacility() {
        return facility;
    }

    public void setFacility(LocationFacilities facility) {
        this.facility = facility;
    }

    public Concept getConfirmationSite() {
        return confirmationSite;
    }

    public void setConfirmationSite(Concept confirmationSite) {
        this.confirmationSite = confirmationSite;
    }

    public Concept getOutcome() {
        return outcome;
    }

    public void setOutcome(Concept outcome) {
        this.outcome = outcome;
    }

    public PatientProgramRegimen getRegimen() {
        return regimen;
    }

    public void setRegimen(PatientProgramRegimen regimen) {
        this.regimen = regimen;
    }

    public Boolean getTransferred() {
        return transferred;
    }

    public void setTransferred(Boolean transferred) {
        this.transferred = transferred;
    }

    public String getSecondLineNumber() {
        return secondLineNumber;
    }

    public void setSecondLineNumber(String secondLineNumber) {
        this.secondLineNumber = secondLineNumber;
    }

    public Date getSecondLineDate() {
        return secondLineDate;
    }

    public void setSecondLineDate(Date secondLineDate) {
        this.secondLineDate = secondLineDate;
    }

    public String getWeight() {
        MdrtbPatientProgram pp = new MdrtbPatientProgram(patientProgram);
        if (pp.getInitialWeightObsDuringProgram() != null){
            weight = pp.getInitialWeightObsDuringProgram().getValueNumeric().toString();
        }

        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        MdrtbPatientProgram pp = new MdrtbPatientProgram(patientProgram);
        if (pp.getInitialHeightObsDuringProgram() != null){
            height = pp.getInitialHeightObsDuringProgram().getValueNumeric().toString();
        }

        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
