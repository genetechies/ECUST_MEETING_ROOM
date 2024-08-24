package com.genetechies.ecust_meeting_room.mapper;
import org.apache.ibatis.annotations.Param;

import com.genetechies.ecust_meeting_room.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 98025
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-20 20:59:00
* @Entity com.genetechies.ecust_meeting_room.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findOneByUsername(@Param("username") String username);

}




