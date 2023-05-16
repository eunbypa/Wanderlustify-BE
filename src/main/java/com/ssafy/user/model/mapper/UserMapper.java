package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	UserDto loginUser(UserDto userDto) throws SQLException;
	void joinUser(UserDto dto)throws SQLException;
	List<UserDto> getUsersInfo(Map<String,  Object> map)throws SQLException;
	void deleteUser(String id)throws SQLException;
	UserDto getUserInfo(String id)throws SQLException;
	void modifyUserInfo(UserDto dto)throws SQLException;
	void joinAgainUser(UserDto userDto)throws SQLException;
	int getTotalMemberCount(Map<String, Object> param) throws SQLException;
}
