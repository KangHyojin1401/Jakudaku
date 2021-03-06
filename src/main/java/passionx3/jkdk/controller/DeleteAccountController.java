package passionx3.jkdk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import passionx3.jkdk.domain.Account;
import passionx3.jkdk.service.jkdkFacade;
import passionx3.jkdk.util.Message;

@Controller
@RequestMapping("/user/deleteAccount.do")
public class DeleteAccountController {
	
	@Autowired
	private jkdkFacade jkdkStore;
	
	@Value("DeleteAccountForm")
	private String formViewName;
	
	@ModelAttribute("DeleteAccountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		return new AccountForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteAccount(@RequestParam("account.password") String password, 
			 HttpSession session, Model model) throws Exception {
		Account curAccount = (Account)session.getAttribute("userSession");
		try {
			if (curAccount.getPassword().equals(password)) {
				jkdkStore.removeAccount(curAccount.getUserId());
				session.removeAttribute("userSession");
				session.invalidate();
			} else {
				return formViewName;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return formViewName; 
		}
		
		model.addAttribute("data", new Message("회원탈퇴가 완료되었습니다.", "/"));
		return "thyme/utils/MessagePage";
	}
}
