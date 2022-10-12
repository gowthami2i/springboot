package com.ideas2it.springboot.dto;

import lombok.Builder;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TraineeDto {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private long mobileNumber;

    private String email;
    private String bloodGroup;

    private long aadharNumber;

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

   public Set <TrainerDto> getTrainerDtoList() {
        return trainerDtoList;
    }

    public void setTrainerDtoList(List<TraineeDto> traineeDtoList) {
        this.trainerDtoList = trainerDtoList;
    }

    public String toString() {
        return ("Trainee Id" +getId() +
                "Trainee First Name" + getFirstName()+
                "Trainee LastName "+getLastName()+
                "Trainee Mobile Number"+ getMobileNumber()+
                "Trainee Aadhar Number" + getAadharNumber()+
                "Trainee Pan Card"+getPanCard()+
                "Trainee Trainerdetails"+getTrainerDtoList());
    }



}
