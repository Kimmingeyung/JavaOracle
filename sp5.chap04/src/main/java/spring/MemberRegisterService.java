package spring;

	
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;

	//생성자 호출방식
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//매개변수 호출 - 필요할때만 생성할 수 있다.
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());

		//회원 중복확인
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		// 중복값이 아닐경우 
		Member newMember = new Member(	
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
