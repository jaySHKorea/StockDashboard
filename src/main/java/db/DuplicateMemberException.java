//회원정보(이메일) 중복 예외처리
package db;

public class DuplicateMemberException extends RuntimeException{
	
	public DuplicateMemberException(String message) {
		super(message);
	}

}
