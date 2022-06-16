package com.charactersheet.charactersheet;

import lombok.ToString;

@ToString
public class PlayerCharacter {

    private String Name;
    private String race;
    private int level;
    private int[] attributes;
    private int[] modifiers = new int[6];
    private int profBonus;

    public PlayerCharacter() {
    }

    public PlayerCharacter(String name, String race, int level, int[] attributes) {
        Name = name;
        this.race = race;
        this.level = level;
        this.attributes = attributes;
        setModifiers();
        setProfBonus();
    }

    //region Default Getters&Setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }

    public int[] getModifiers() {
        return modifiers;
    }

    public int getProfBonus() {
        return profBonus;
    }

    //endregion


    //region Private Methods
    private void setProfBonus(){
        double tempLevel = (double) getLevel();
        double dBonus = Math.ceil(1+(tempLevel/4));
        this.profBonus = (int) dBonus;
    }

    private void setModifiers(){
        int[] tempScores = getAttributes();
        for (int i = 0; i < tempScores.length; i++) {
            double a = (double) tempScores[i];      //cast int[i] to double
            double b = Math.floor((a-10)/2);        //calculate modifier  (tempScores[i]-10)/2
            this.modifiers[i] = (int) b;            //assign result to modifier[i]
        }
    }

    //endregion

    //region Public Methods
    public void levelUp(){
        if (level == 20){
            System.out.println("Already at Max Level!\n");
        }else {
            level++;
            setProfBonus();
        }
    }
    //endregion
}