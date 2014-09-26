package com.ejb3unit.entitytests;

import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.SingleBeanGenerator;
import com.bm.testsuite.BaseEntityFixture;
import com.ejb3unit.LineItem;
import com.ejb3unit.Order;

/**
 * This is an axample for fully automated entity bean testing. Beans are randomly
 * generated and written to an in momory database. Equals and hashcode
 * imlementations will be automatically checked. 
 * This test test a entity bean with property access and a N:1 releation.
 * 
 * @author Daniel Wiese
 * 
 */
public class LineItemTest extends BaseEntityFixture<LineItem> {

	private static final Generator[] SPECIAL_GENERATORS = { new MyOrderCreator() };

	/**
	 * Default constructor.
	 */
	public LineItemTest() {
		super(LineItem.class, SPECIAL_GENERATORS);
	}

	/**
	 * Innec Test class.
	 * 
	 * @author Daniel Wiese
	 * @since 21.11.2005
	 */
	@GeneratorType(className = Order.class)
	private static final class MyOrderCreator extends
			SingleBeanGenerator<Order> {
		private MyOrderCreator() {
			super(Order.class);
		}
	}
}
