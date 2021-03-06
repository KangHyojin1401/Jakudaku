package passionx3.jkdk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import passionx3.jkdk.domain.Cart;
import passionx3.jkdk.domain.Online;
import passionx3.jkdk.service.jkdkFacade;

@Controller
@SessionAttributes("sessionCart")
public class AddItemToCartController { 
	@Autowired
	private jkdkFacade jkdkStore;

	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
	@ResponseBody
	@GetMapping(value="/shop/addItemToCart.do", produces="text/plain")
	public String addItemToCart(
			@RequestParam("itemId") int itemId,
			@ModelAttribute("sessionCart") Cart cart,
			Model model) throws Exception {
		if (cart.containsItemId(itemId)) {
			return "장바구니에 이미 담긴 상품입니다.";
		} else {
			Online item = this.jkdkStore.getOnlineItemById(itemId);
			cart.addItem(item);
		
			return "선택하신 상품을 장바구니에 담았습니다.";
		}
	}
	
	@RequestMapping("/shop/goToCart.do")
	public ModelAndView goToCart(
			@RequestParam("itemId") int itemId,
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		
		return new ModelAndView("Cart", "cart", cart);
	}
}