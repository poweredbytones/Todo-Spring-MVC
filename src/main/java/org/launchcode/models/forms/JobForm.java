package org.launchcode.models.forms;

import org.hibernate.validator.constraints.NotEmpty;
import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    //@Size(min=1,message = "employerId may be empty")
    private int employerId;

    @NotEmpty
    @Size(min=1,message = "employers may not be empty")
    private ArrayList<Employer> employers;

    private String employer;

    @NotEmpty
    @Size(min=1,message = "locations may not be empty")
    private ArrayList<Location> locations;


    private int location;



    @NotEmpty
    @Size(min=1,message = "coreCompetencies may not be empty")
    private ArrayList<CoreCompetency> coreCompetencies;

    @NotEmpty
    @Size(min=1,message = "positionTypes may not be empty")
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();



        employers = jobData.getEmployers().findAll();
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();

    }

//    private String

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public String getEmployer() {return employer;}

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }


    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public int getPositionType() {
        return PositionType;
    }

    public void setPositionType(int positionType) {
        PositionType = positionType;
    }

    public int getCoreCompetency() {
        return CoreCompetency;
    }

    public void setCoreCompetency(int coreCompetency) {
        CoreCompetency = coreCompetency;
    }

    private int PositionType;

    private int CoreCompetency;

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
}
