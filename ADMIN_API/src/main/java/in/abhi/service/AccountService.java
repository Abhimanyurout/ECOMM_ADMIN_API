package in.abhi.service;

import java.util.List;

import in.abhi.bindings.UnlockAccForm;

public interface AccountService {
	
	public boolean createUserAccount(UserAccountForm accForm);
	
	public List<UserAccountFrom> fetchUserAccounts();
	
	public UserAccountForm getUserAccById(Integer accId);
	
	public String changeAccStatus(Integer accId, String status);
	
	public String unlockUserAccount(UnlockAccForm unlockAccForm);
}













