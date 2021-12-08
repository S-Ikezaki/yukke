package com.example.demo.model.tag;

import com.example.demo.model.user.Request;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tag_request_mst")
public class TagRequest implements Serializable{
    @Id
    @Column(name = "tag_id")
    private int tagId;

    @Id
    @Column(name = "request_id")
    private long requestId;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id",insertable = false, updatable=false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id",insertable = false, updatable=false)
    private Tag tag;
}
