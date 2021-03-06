package passionx3.jkdk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import passionx3.jkdk.domain.Funding;
import passionx3.jkdk.domain.Pagination;
import passionx3.jkdk.domain.Theme;
import passionx3.jkdk.service.jkdkFacade;

@Controller
@SessionAttributes("userSession")
public class ViewFundingsController {

	@Autowired
	private jkdkFacade jkdkStore;

	@RequestMapping("/item/viewFundings.do")
	public ModelAndView handleRequest(
			@RequestParam("themeId") int themeId, 
			@RequestParam("sortBy") int sortBy,
			@RequestParam("page") int page,
			@RequestParam(value="keyword", required=false) String keyword) throws Exception {

		if (keyword == null) keyword = "";
		
		int itemPerPage = 16;
		int end = page * itemPerPage;
		int start = end - itemPerPage + 1;
		
		List<Funding> fundingList = jkdkStore.getFundingItemList(themeId, keyword, sortBy, start, end);
		int totalItemCount = jkdkStore.getCountOfFundingItemList(themeId, keyword, start, end);
		
		Pagination pagination = new Pagination(page, itemPerPage, totalItemCount);
		
		List<Theme> allThemes = jkdkStore.getAllThemes();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thyme/item/ViewFundings");
		mav.addObject("allThemes", allThemes);
		mav.addObject("themeId", themeId);
		mav.addObject("keyword", keyword);
		mav.addObject("sortBy", sortBy);
		mav.addObject("fundingList", fundingList);
		mav.addObject("pagination", pagination);
		
		return mav;
	}
}
