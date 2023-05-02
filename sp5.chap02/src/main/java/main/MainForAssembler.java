package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

public class MainForAssembler {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			System.out.println("명령어를 입력하세요:");
			//입력값
			String command = reader.readLine();
			//종료조건
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if (command.startsWith("new ")) {  // 회원가입
				//회원가입 입력형식 : new gildong@naver.com 홍길동 1234 1234 
				processNewCommand(command.split(" "));
				continue;
			
			} else if (command.startsWith("change ")) { 
				// 비밀번호 변경 :change 이메일 현재비번 변경비번
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	private static Assembler assembler = new Assembler();

	//비지니스 로직의 핵심
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp(); // arg값이 5개이상 일경우 입력형식이 맞지 않음을 안내함 
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n"); // pw와 컴펌패스워드가 불일치
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) { // 중복 검사
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) { 
			printHelp(); // 비번변경시에 포맷이 맞지 않을 때 안내문 출력 
			return;
		}
		ChangePasswordService changePwdSvc = 
				assembler.getChangePasswordService();
		try {
			//암호 변경 함수 changePassword 
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("기존 암호가 일치하지 않습니다.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
}