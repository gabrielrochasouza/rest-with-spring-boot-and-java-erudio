package br.com.erudio.apigateway.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name="person")
public class Person implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 80)
    private String name;

    @Column(length = 80)
    private String address;

    @Column(length = 6)
    private String gender;

    public Person() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
