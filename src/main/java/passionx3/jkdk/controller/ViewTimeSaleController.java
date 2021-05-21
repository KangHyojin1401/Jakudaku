package passionx3.jkdk.controller;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import passionx3.jkdk.dao.mybatis.MybatisTimeSaleDao;
import passionx3.jkdk.domain.TimeSale;

@Controller
public class ViewTimeSaleController { 
	
	@Autowired
	private MybatisTimeSaleDao timeSaleDao = new MybatisTimeSaleDao();
	
	@RequestMapping("/timesale/viewtimeSale.do")
	public String handleRequest(ModelMap model) throws Exception {
		TimeSale timeSale = timeSaleDao.getTimeSale();

		//Item item = itemDao.getItem(timeSale.getItemId());
		
		model.put("timeSale", timeSale);
		//model.put("item", item);
		model.put("timeSale", timeSale);
		return "thyme/sale/TimeSale";
	}
}
