package com.ideas2it.springboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

public class TraineeDto {
    @NotEmpty(message = "Enter the valid name valid name")
    @Pattern(regexp = "[A-Za-z\\s]{2,29}", message = "Enter the valid name")
    private String firstName;
    @Pattern(regexp = "[A-Za-z\\s]{0,3}", message = "Enter the valid last Name")
    @NotEmpty(message = " Last Name is empty")
    private String lastName;
    private LocalDate dateOfBirth;
    @Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "Enter the valid mobile Number")
    @NotEmpty(message = "mobile number is empty")
    private long mobileNumber;
    @Email(message = "Enter the valid email id")
    private String email;
    @Pattern(regexp = "(A|B|AB|O)[+-]", message = "enter the valid blood group")
    private String bloodGroup;
    @Pattern(regexp = "[1-9]{12}", message = "Enter the valid aadharnumber")
    private long aadharNumber;
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Enter the valid pancard number")
    private String panCard;
    private boolean isRemoved;
    private LocalDate dateOfJoinning;
    private int id;
    private String skillSet;
    private int task;

    private Set<TrainerDto> trainerDtoList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public LocalDate getDateOfJoinning() {
        return dateOfJoinning;
    }

    public void setDateOfJoinning(LocalDate dateOfJoinning) {
        this.dateOfJoinning = dateOfJoinning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public void setTrainerDtoList(Set<TrainerDto> trainerDtoList) {
        this.trainerDtoList = trainerDtoList;
    }

    public Set<TrainerDto> getTrainerDtoList() {
        return trainerDtoList;
    }

    @Override
    public String toString() {
        return ("Trainee Id" + getId() +
                "Trainee First Name" + getFirstName() +
                "Trainee LastName " + getLastName() +
                "Trainee Mobile Number" + getMobileNumber() +
                "Trainee Aadhar Number" + getAadharNumber() +
                "Trainee Pan Card" + getPanCard() +
                "Trainee Trainerdetails" + getTrainerDtoList());
    }


}
