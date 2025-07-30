package com.example.entity;
import jakarta.persistence.*;
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String passportNumber;
    @OneToOne(mappedBy = "passport")
    private Citizen citizen;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public Citizen getCitizen() { return citizen; }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }
}
