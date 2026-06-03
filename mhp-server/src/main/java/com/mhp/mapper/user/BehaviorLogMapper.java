package com.mhp.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BehaviorLogMapper {

    @Insert("INSERT INTO bh_behavior_log (student_id, event_type, event_data) VALUES (#{studentId}, #{eventType}, #{eventData})")
    void insert(@Param("studentId") Long studentId, @Param("eventType") String eventType, @Param("eventData") String eventData);
}
