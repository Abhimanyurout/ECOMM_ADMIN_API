package in.abhi.service;

import in.abhi.bindings.DashboardCard;
import in.abhi.bindings.LoginForm;
import in.abhi.bindings.UserAccForm;

public interface UserService {
	
	public String login(LoginForm loginForm);
	
	public boolean recoverPwd(String email);
	
	public DashboardCard fetchDashboardInfo();
	
	public UserAccForm getUserByEmail(String email);
	
	
}








