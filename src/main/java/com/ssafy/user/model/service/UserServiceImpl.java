package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class UserServiceImpl implements IUserService {
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public void joinUser(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		UserDto user = this.getUserInfo(userDto.getId());
		if(user != null) { // 이전에 가입했다가 탈퇴했던 유저
			userMapper.joinAgainUser(userDto);
		}else {
			userMapper.joinUser(userDto);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto loginUser(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.loginUser(userDto);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto getUserInfo(String userId) throws Exception{
		// TODO Auto-generated method stub
		return userMapper.getUserInfo(userId);
	}

	@Override
	@Transactional
	public void modifyUserInfo(UserDto userDto) throws Exception{
		// TODO Auto-generated method stub
		userMapper.modifyUserInfo(userDto);
	}

	@Override
	@Transactional
	public void  deleteUser(String userId) throws Exception{
		// TODO Auto-generated method stub
		userMapper.deleteUser(userId);
	}
	@Override
	@Transactional(readOnly = true)
	public int checkId(String userId) throws Exception{
		// TODO Auto-generated method stub
		UserDto userDto = userMapper.getUserInfo(userId);
		if(userDto == null || userDto.getFlag() == 1) return 0; //해당 아이디로 한번도 가입한 이력이 없거나 탈퇴한 이력이 있는 경우
		return 1;
	}
	@Override
	@Transactional(readOnly = true)
	public List<UserDto> getUsersInfo(Map<String, String> map) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("userId".equals(key))
			key = "user_id";
		if("userName".equals(key))
			key = "user_name";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		
		return userMapper.getUsersInfo(param);
	}
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("userId".equals(key))
			key = "id";
		if("userName".equals(key))
			key = "name";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = userMapper.getTotalMemberCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		userMapper.deleteRefreshToken(map);
	}
}
