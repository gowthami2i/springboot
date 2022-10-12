package com.ideas2it.springboot.dto;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Data
public class TrainerDto {

    @NotEmpty(message = "Enter the valid name valid name")
    @Pattern(regexp = "[A-Za-z\\s]{2,29}", message = "Enter the valid name")
    private String firstName;
    @Pattern(regexp = "[A-Za-z\\s]{0,3}", message = "Enter the valid last Name")
    @NotEmpty(message = " Last Name is empty")
    private String lastName;
    private LocalDate dateOfBirth;
    //@Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "Enter the valid mobile Number")
    //@NotEmpty(message = "mobile number is empty")

    private String mobileNumber;
    @Email(message = "Enter the valid email id")
    private String email;
    @Pattern(regexp = "(A|B|AB|O)[+-]",message = "enter the valid blood group")
    private String bloodGroup;
    @Pattern(regexp = "[1-9]{12}",message = "Enter the valid aadharnumber")
    private String aadharNumber;
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter the valid pancard number")
    private String panCard;
    private boolean isRemoved;
    private LocalDate dateOfJoinning;
    private int id;
   // @Pattern(regexp = "[1-20]{2}]", message = "Enter the valid number of projects")
    private int project;
  //  @Pattern(regexp = "[1-30]{2}", message = "Enter the valid experience")
    private int experience;
    private Set<TraineeDto> traineeDtoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<TraineeDto> getTraineeDtoList() {

        return traineeDtoList;
    }

    public void setTraineeDtoList(Set<TraineeDto> traineeDtoList) {

        this.traineeDtoList = traineeDtoList;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfJoinning(LocalDate dateOfJoinning) {
        this.dateOfJoinning = dateOfJoinning;
    }

    public LocalDate getDateOfJoinning() {
        return dateOfJoinning;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public String toString() {
        return ("Trainer Id" + getId() +
                "Trainer First Name" + getFirstName() +
                "Trainer LastName " + getLastName() +
                "Trainer Mobile Number" + getMobileNumber() +
                "Trainer Aadhar Number" + getAadharNumber() +
                "Trainer Pan Card" + getPanCard() +
                "Trainer Traineedetails" + getTraineeDtoList());
    }
}

