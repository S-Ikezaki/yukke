package com.example.demo.repository;

import com.example.demo.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long>{
    //名前で検索するメソッド
   /* @Query(name = "Group.findByName")
    List<Group> findByName(String name);*/

    //タグで検索するメソッド
//    @Query(name = "Group.findByTagNq",nativeQuery = true)
//    List<Group> findByTagNq(Tag tagName);
//
//    @Query(name = "Group.findCompetitionNameByTagNq",nativeQuery = true)
//    List<Group> findCompetitionByTag(Tag tagName);

    //グループごとのメッセージを表示するためのメソッド
//    @Query(name = "Message.findMessageByGroupNq",nativeQuery = true)
//    List<Group> findMessageByGroup(Group groupId);


}
