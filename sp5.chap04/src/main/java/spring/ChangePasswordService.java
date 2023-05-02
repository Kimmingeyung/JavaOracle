package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		// #email값을 가져옴
		Member member = memberDao.selectByEmail(email);
		if (member == null) // 값이 없다면 예외발생 
			throw new MemberNotFoundException(); //runtimeExcpetion

		member.changePassword(oldPwd, newPwd);  //기존 패스워드 인증후 새로운 비밀번호로 갱신 

		memberDao.update(member); // member 정보를 갱신
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
