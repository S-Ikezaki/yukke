package com.example.demo.model.group;

import com.example.demo.model.tag.TagGroup;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "group_mst")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id",nullable = false)
    private String groupId;

    @Column(name = "group_name",nullable = false)
    private String groupName;

    @Column(name = "role",nullable = false)
    private int groupRole;

    @Column(name = "group_bio")
    private String groupBio;

    @OneToMany
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    List<TagGroup> tagGroups;

    @OneToMany
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    List<File> files;

    @OneToMany
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    List<GroupMember> groupMembers;

    @OneToMany
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    List<GroupMessage> groupMessages;

    @OneToMany
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    List<Meeting> meetings;

}
