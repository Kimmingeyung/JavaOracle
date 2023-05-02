package spring;

import java.time.LocalDateTime;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	//암호 변경  - 기존의 패스워드 (인증) 후에 암호변경을 허용함
	public void changePassword(String oldPassword, String newPassword) {
		// 기존 패스워드와 같지 않다면 예외처리
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException(); //runtimeExcpetion
		//패스워드 갱신
		this.password = newPassword;
	}

}
