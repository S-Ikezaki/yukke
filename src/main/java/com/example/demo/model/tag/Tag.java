package com.example.demo.model.tag;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "tag_mst")
public class Tag{
    @Id
    @Column(name = "tag_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    @Column(name ="tag_name",nullable = false)
    private String tagName;

    @OneToMany
    @JoinColumn(name = "tag_id",referencedColumnName = "tag_id",insertable = false, updatable=false)
    List<TagUser> tagUsers;

    @OneToMany
    @JoinColumn(name = "tag_id",referencedColumnName = "tag_id",insertable = false, updatable=false)
    List<TagRequest> tagRequestList;

    @OneToMany
    @JoinColumn(name = "tag_id",referencedColumnName = "tag_id",insertable = false, updatable=false)
    List<TagGroup> tagGroups;
}
