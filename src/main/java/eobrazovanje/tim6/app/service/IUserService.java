package eobrazovanje.tim6.app.service;

import eobrazovanje.tim6.app.entity.User;

public interface IUserService {
	
	public User findById(Long roleId);
	public User findByUserName(String userName);

}
