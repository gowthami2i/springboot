package com.ideas2it.springboot.dto;

import java.util.List;

public class AssociationDto {

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    private int trainerId;

    public List<Integer> getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(List<Integer> traineeId) {
        this.traineeId = traineeId;
    }

    private List<Integer> traineeId;
}
