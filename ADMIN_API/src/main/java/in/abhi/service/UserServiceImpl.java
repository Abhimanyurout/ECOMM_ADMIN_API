package in.abhi.service;

import org.springframework.stereotype.Service;

import in.abhi.bindings.DashboardCard;
import in.abhi.bindings.LoginForm;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public String login(LoginForm loginForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DashboardCard fetchDashboardInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
