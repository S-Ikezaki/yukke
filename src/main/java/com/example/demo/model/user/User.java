package com.example.demo.model.user;

import com.example.demo.model.tag.TagUser;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="user_mst")
public class User implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

//    @Column(name = "user_role", nullable = false)
//    private int userRole;

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    List<Student> students;

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    List<Teacher> teachers;

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    List<Employee> employees;

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    List<TagUser> tagUsers;

    @OneToMany
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    List<Request> requests;

    @OneToMany
    @JoinColumn(name="create_user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    //@JoinColumn(name="address_user_id",referencedColumnName = "user_id")
    //宛先が難しいです
    List<DirectMessage> directMessages;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    private Certification certification;
}
