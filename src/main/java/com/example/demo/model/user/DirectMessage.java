package com.example.demo.model.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "direct_message_mst")
public class DirectMessage implements Serializable {
    @Id
    @Column(name = "direct_message_id" ,nullable = false)
    private long directMessageId;

    @Id
    @Column(name = "create_user_id" ,nullable = false)
    private String createUserId;

    @Column(name = "create_user_name" ,nullable = false)
    private String createUserName;

    @Id
    @Column(name ="address_user_id" ,nullable = false)
    private String addressUserId;

    @Column(name = "address_user_name" ,nullable = false)
    private String addressUserName;

    @Column(name = "direct_message_contents" ,nullable = false)
    private String directMessageContent;

    @Column(name = "create_datetime" ,nullable = false)
    private Date createDatetime;

    @ManyToOne
//    @JoinColumn(name = "create_user_id",referencedColumnName = "user_id")
    @JoinColumn(name = "address_user_id",referencedColumnName = "user_id",insertable = false, updatable=false)
    //宛先が難しいです
    private User user;

}
