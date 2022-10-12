package com.ideas2it.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ideas2it.springboot.model.Trainee;
import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TrainerDto {
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

    private int project;

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

    public long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(long aadharNumber) {
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

