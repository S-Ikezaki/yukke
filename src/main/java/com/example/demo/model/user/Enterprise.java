package com.example.demo.model.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "enterprise_mst")
public class Enterprise implements Serializable {
    @Id
    @Column(name = "enterprise_id" ,nullable = false)
    private String enterpriseId;

    @Column(name = "enterprise_name" ,nullable = false)
    private String enterpriseName;

    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "enterprise_id",insertable = false, updatable=false)
    List<Employee> employee;
}
