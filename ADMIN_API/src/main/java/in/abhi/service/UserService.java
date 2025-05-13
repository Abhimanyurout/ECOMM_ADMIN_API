package in.abhi.service;

import in.abhi.bindings.DashboardCard;
import in.abhi.bindings.LoginForm;

public interface UserService {
	
	public String login(LoginForm loginForm);
	
	public boolean recoverPwd(String email);
	
	public DashboardCard fetchDashboardInfo();
	
	
}








