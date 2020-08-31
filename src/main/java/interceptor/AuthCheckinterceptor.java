package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckinterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object authInfo = session.getAttribute("authInfo"); // session에 authInfo 속성이 존재하면 true
			if (authInfo != null) {
				return true; // 컨트롤러 실행(로그인 상태)
			}
		}
		response.sendRedirect(request.getContextPath()+"/login"); // 현재 컨텍스트 경로 return : /sp5-chap13
		return false;
	}
}
