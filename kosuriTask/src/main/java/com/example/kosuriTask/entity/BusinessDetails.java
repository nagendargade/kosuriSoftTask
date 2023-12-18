package com.example.kosuriTask.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    @Column(name = "contactEmail", unique = true)
    private String contactEmail;
    private long phoneNumber ;
    private String businessName;
    private String nbfcApproved;
    private String nbfcRegistrationNumber;
    @CreationTimestamp
    private Date registartionDate;
    private String gstRegistration;
    @UpdateTimestamp
    private Date updatedDetails;
}
