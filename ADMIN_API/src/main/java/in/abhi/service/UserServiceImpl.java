package in.abhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.abhi.bindings.DashboardCard;
import in.abhi.bindings.LoginForm;
import in.abhi.entities.EligEntity;
import in.abhi.entities.UserEntity;
import in.abhi.repositories.EligRepo;
import in.abhi.repositories.PlanRepo;
import in.abhi.repositories.UserRepo;
import in.abhi.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private EligRepo eligRepo;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Override
	public String login(LoginForm loginForm) {
		UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());
		if(null==entity) {
			return "Invalid Credentials";
		}
		if("Y".equals(entity.getActiveSw()) && "UNLOCKED".equals(entity.getAccStatus())) {
			return "success";
		}else {
			return "Account locked/Invalid";
		}
		
	}

	@Override
	public boolean recoverPwd(String email) {
		UserEntity userEntity = userRepo.findByEmail(email);		
		if(null==userEntity) {
			return false;
		}else {
			String subject="";
			String body="";
			return emailUtils.sendEmail(subject, body, email);
		}		
		
	}

	@Override
	public DashboardCard fetchDashboardInfo() {
		long plansCount = planRepo.count();
		
		List<EligEntity> eligList = eligRepo.findAll();
		long approvedCnt = eligList.stream().filter(ed-> ed.getPlanStatus().equals("AP")).count();
		long deniedCnt = eligList.stream().filter(ed-> ed.getPlanStatus().equals("DN")).count();
		double total = eligList.stream().mapToDouble(ed-> ed.getBenefitAmt()).sum();
		
		DashboardCard card=new DashboardCard();
		
		card.setPlansCnt(plansCount);
		card.setApprovedCnt(approvedCnt);
		card.setDeniedCnt(deniedCnt);
		card.setBeniftAmtGiven(total);

		return card;
	}

}
