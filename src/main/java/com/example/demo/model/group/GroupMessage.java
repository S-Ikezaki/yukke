package com.example.demo.model.group;

import com.example.demo.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "group_message_mst")
public class GroupMessage implements Serializable {
    @Id
    @Column(name="group_message_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String groupMessageId;

    @Id
    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Id
    @Column(name="group_id",nullable = false)
    private String groupId;

    @Column(name="create_datetime")
    private Date createDatetime;

    @Column(name="message_contents",nullable = false)
    private String messageContents;


    @ManyToOne
    @JoinColumn(name="group_id",referencedColumnName = "group_id",insertable = false, updatable=false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    private User user;

}
