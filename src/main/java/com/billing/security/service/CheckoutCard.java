package com.billing.security.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billing.domain.OrderDetail;
import com.billing.domain.Product;
import com.billing.domain.SelectedItem;
import com.billing.security.service.HomeService.HomeResponse;

@RequestMapping("/rest")
@RestController
public class CheckoutCard {

	static HashMap<Integer , Product> listProduct = new  HashMap<Integer, Product>() ;

	static {
		listProduct.put(1, new Product(1, "prod_A_1", "A", 212.5, 10));
		listProduct.put(2, new Product(2, "prod_A_2", "A", 142.1, 10));
		listProduct.put(3, new Product(3, "prod_A_3", "A", 332.1, 20));
		listProduct.put(4, new Product(4, "prod_A_4", "A", 132.6, 12));
		listProduct.put(5, new Product(5, "prod_B_1", "B", 132.1, 10));
		listProduct.put(6, new Product(6, "prod_B_2", "B", 123.1, 20));
		listProduct.put(7, new Product(7, "prod_B_3", "B", 444.1, 10));
		listProduct.put(8, new Product(8, "prod_B_4", "B", 555, 10));
		listProduct.put(9, new Product(9, "prod_C_1", "C`", 545.1, 10));
		listProduct.put(10, new Product(10, "prod_C_2", "C", 1222.1, 10));
	}

	@RequestMapping(value = "/productlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<Integer, Product> getProductList(Principal principal) {
		return listProduct;
	}

	@RequestMapping(value = "/generatebill", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetail generateBill(@RequestBody ArrayList<SelectedItem> selectedItems) {
		int total = 0;
		double totalPrice = 0;
		double totalServiceTax = 0;
		ArrayList<Product> selectedProduct = new ArrayList<Product>();
		for (SelectedItem item : selectedItems) {
			totalPrice += listProduct.get(item.getItemId()).getPrice();
			totalServiceTax += listProduct.get(item.getItemId()).getServicetaxprice();
			selectedProduct.add(listProduct.get(item.getItemId()));
		}
		OrderDetail orderDetail = new OrderDetail(String.valueOf(UUID.randomUUID()), totalPrice, totalServiceTax,
				selectedProduct);
		return orderDetail;
	}

}
