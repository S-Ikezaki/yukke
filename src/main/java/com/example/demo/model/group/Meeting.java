package com.example.demo.model.group;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "meeting_mst")
public class Meeting{
    @Id
    @Column(name = "group_id",nullable = false)
    private String groupId;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    private Group group;

}
