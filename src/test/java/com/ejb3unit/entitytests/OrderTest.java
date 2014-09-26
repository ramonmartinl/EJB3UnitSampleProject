package com.ejb3unit.entitytests;

import java.util.Collection;

import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.BeanCollectionGenerator;
import com.bm.testsuite.BaseEntityFixture;
import com.ejb3unit.LineItem;
import com.ejb3unit.Order;

/**
 * This is an axample for fully automated entity bean testing. Beans are randomly
 * generated and written to an in momory database. Equals and hashcode
 * imlementations will be automatically checked. 
 * 
 * @author Daniel Wiese
 * 
 */
public class OrderTest extends BaseEntityFixture<Order> {

	private static final Generator[] SPECIAL_GENERATORS = { new MyLineItemCreator() };

	/**
	 * Default constructor.
	 */
	public OrderTest() {
		super(Order.class, SPECIAL_GENERATORS);
	}

	/**
	 * Generator for releated collection
	 * 
	 * @author Daniel Wiese
	 */
	@GeneratorType(className = Collection.class, field = "lineItems")
	private static final class MyLineItemCreator extends
			BeanCollectionGenerator<LineItem> {
		private MyLineItemCreator() {
			super(LineItem.class, 10);
		}
	}

}
