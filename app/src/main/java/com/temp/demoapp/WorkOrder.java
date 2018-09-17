package com.temp.demoapp;

import java.io.Serializable;
import java.util.List;

public class WorkOrder implements Serializable{

    private String description;
    private String planningPlant;
    private String workCenter;
    private String type;
    private String typeDescription;
    private String functionLoc;
    private String history;
    private String prt;
    private String number;
    private String priority;
    private String date;
    private List<String> notes;

    public WorkOrder(String description, String planningPlant, String workCenter, String type, String typeDescription, String functionLoc, String history, String prt, String number, String priority, String date) {
        this.description = description;
        this.planningPlant = planningPlant;
        this.workCenter = workCenter;
        this.type = type;
        this.typeDescription = typeDescription;
        this.functionLoc = functionLoc;
        this.history = history;
        this.prt = prt;
        this.number = number;
        this.priority = priority;
        this.date = date;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public WorkOrder() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlanningPlant() {
        return planningPlant;
    }

    public void setPlanningPlant(String planningPlant) {
        this.planningPlant = planningPlant;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDesription() {
        return typeDescription;
    }

    public void setTypeDesription(String typeDesription) {
        this.typeDescription = typeDesription;
    }

    public String getFunctionLoc() {
        return functionLoc;
    }

    public void setFunctionLoc(String functionLoc) {
        this.functionLoc = functionLoc;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getPrt() {
        return prt;
    }

    public void setPrt(String prt) {
        this.prt = prt;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
