package com.billing.security.application;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.billing.domain.OrderDetail;
import com.billing.domain.Product;
import com.billing.domain.SelectedItem;
import com.billing.security.service.CheckoutCard;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	CheckoutCard card;
	
	@Before
    public void setUp() throws Exception {
        card = new CheckoutCard( );
    }
	
	@Test
	public void getProductListTest(){
		HashMap<Integer, Product> list = card.getProductList( );
		assertNotNull(list);
		assertEquals("Size is 10 " , 10 , list.size());
	}
	@Test
	public void generateBillTest(){
		ArrayList<SelectedItem> selectedItems = new ArrayList<SelectedItem>();
		SelectedItem item = new SelectedItem();
		item.setItemId(2);
		item.setQuantity(1);
		selectedItems.add(item);
		OrderDetail orderDetail = card.generateBill(selectedItems);
		assertNotNull(orderDetail);
		assertEquals( 142.1 , orderDetail.getTotalprice(), 1) ;
	}
	
}
