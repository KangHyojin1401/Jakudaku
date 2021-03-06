package passionx3.jkdk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import passionx3.jkdk.service.jkdkFacade;
import passionx3.jkdk.util.FileUtils;
import passionx3.jkdk.domain.Account;
import passionx3.jkdk.domain.Funding;
import passionx3.jkdk.domain.Theme;

@Controller
@SessionAttributes("userSession")
public class SellFundingItemController {
	@Value("thyme/item/SellFundingItemForm")
	private String formViewName;
		
	private jkdkFacade jkdk;
	@Autowired
	public void setJkdk(jkdkFacade jkdk) {
		this.jkdk = jkdk;
	}

	@Autowired
	private FileUtils fileUtils;
	
	@ModelAttribute("sellFundingForm")
	public SellFundingForm formBackingObject(HttpServletRequest request) throws Exception {
		String itemId = request.getParameter("itemId");
		
		if (itemId != null) {
			return new SellFundingForm(jkdk.getFundingItemById(Integer.parseInt(itemId)));
		} else { 
			return new SellFundingForm();
		}
	}
	
	@ModelAttribute("themeList")
	public List<Theme> getThemeList() { // accessor method
		return jkdk.getAllThemes();
	}
	
	@GetMapping("/item/sellFundingItem.do")
	public String showForm() {
		return formViewName;
	}

	@PostMapping("/item/sellFundingItem.do") 
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@Valid @ModelAttribute("sellFundingForm") SellFundingForm sellFundingForm,
			BindingResult result,
			@RequestParam(value="thumbnail1", required=false) MultipartFile[] thumbnail) throws Exception {
		
		if (result.hasErrors()) return formViewName;
		try {
			if (sellFundingForm.isNewFunding()) {
				Funding funding = sellFundingForm.getFunding();
				Account account = (Account)session.getAttribute("userSession");
				funding.setProducerId(account.getUserId());
				funding.setProducerName(account.getAlias());
				
				funding = (Funding) fileUtils.uploadFiles(thumbnail, funding);
				
				jkdk.setWaterMark(funding);

				jkdk.registerFundingItem(sellFundingForm.getFunding());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			return formViewName; 
		}
		
		return "redirect:/user/myPage/sell.do";
	}
}
