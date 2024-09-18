package edu.westga.cs1302.bill.test.model.billcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTip {

	@Test
	public void testWhenSubtotalIsZero() {
		BillItem[] items = new BillItem[5];
		
		double result = BillCalculator.getTip(items);
		
		assertEquals(0.0, result, 0.01);
	}

	@Test
	public void testWhenBillHasOneItem() {
		BillItem[] items = new BillItem[5];
		BillItem apple = new BillItem("apple", 2.59);
		
		items[0] = apple;
		double result = BillCalculator.getTip(items);
		
		assertEquals(0.518, result, 0.001);
	}

	@Test
	public void testWhenBillHasMultipleItems() {
		BillItem[] items = new BillItem[5];
		BillItem apple = new BillItem("apple", 2.59);
		BillItem banana = new BillItem("banana", 1.30);
		BillItem orange = new BillItem("orange", 2.99);

		
		items[0] = apple;
		items[1] = banana;
		items[2] = orange;
		double result = BillCalculator.getTip(items);
		
		assertEquals(1.376, result, 0.001);
	}

}
