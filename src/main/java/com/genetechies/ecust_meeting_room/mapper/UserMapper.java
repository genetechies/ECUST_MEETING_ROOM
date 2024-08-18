package com.genetechies.ecust_meeting_room.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.genetechies.ecust_meeting_room.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author 98025
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-18 23:41:46
* @Entity com.genetechies.ecust_meeting_room.domain.User
*/

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findOneByUsername(@Param("username") String username);
}




