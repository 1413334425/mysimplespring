package test.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cf.annotation.Autowired;
import com.cf.annotation.Controller;
import com.cf.annotation.RequestMapping;
import com.cf.annotation.RequestParam;
import com.cf.servlet.ModelAndView;

import test.service.UserService;



@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;

	/**
	 * 测试通过response返回相应
	 *
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/test1")
	public void test1(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param) {
		System.out.println(param);
		try {

			String result = userService.getUser(null == param ? 0 : Integer.parseInt(param));
			response.getWriter().write("doTest method success! param=" + param + ",result=" + result);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 测试返回result字符串
	 *
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 */
	@RequestMapping("/test2")
	public String test2(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param) {
		return userService.getUser(null == param ? 0 : Integer.parseInt(param));
	}

	/**
	 * 测试返回视图
	 *
	 * @param request
	 * @param response
	 * @param param
	 * @return
	 */
	@RequestMapping("/test3")
	public ModelAndView test3(HttpServletRequest request, HttpServletResponse response, @RequestParam("param") String param) {
		
		ModelAndView modelAndView = new ModelAndView();
		String result = userService.getUser(null == param ? 0 : Integer.parseInt(param));
		modelAndView.setViewName("hello.jsp");
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}

	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
