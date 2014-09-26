package com.ejb3unit.entitytests;

import java.util.ArrayList;
import java.util.List;

import com.bm.testsuite.PoJoFixture;
import com.ejb3unit.LineItem;
import com.ejb3unit.Order;

/**
 * Shows the usage of the pojo fixture.
 * 
 */
public class PojoFixtureUsageExampleTest extends PoJoFixture {

	private static final Class<?>[] USED_ENTITIES = { Order.class,
			LineItem.class };

	public PojoFixtureUsageExampleTest() {
		super(USED_ENTITIES);
	}

	public void testToWriteComplexObjectGraph() {
		List<Order> complexObjectGraph = generateTestOrders();

		// persist the graph and load it again
		List<Order> persisted = persist(complexObjectGraph);
		List<Order> allFromDB = findAll(Order.class);

		// assert the persisted graph and the loaded are equal
		assertCollectionsEqual(persisted, allFromDB);
	}

	public void testGetEntityManager() {
		assertNotNull(this.getEntityManager());
	}

	private List<Order> generateTestOrders() {
		final List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setTotal(20);
		order.addPurchase("Testprod1", 30, 30.34);
		order.addPurchase("Testprod2", 31, 31.34);
		order.addPurchase("Testprod3", 32, 32.34);
		order.addPurchase("Testprod4", 33, 33.34);
		orders.add(order);
		return orders;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		deleteAll(LineItem.class);
		deleteAll(Order.class);
	}

	/**
	 * Delets all data. {@inheritDoc}
	 */
	@Override
	public void tearDown() throws Exception {
		deleteAll(LineItem.class);
		deleteAll(Order.class);
		super.tearDown();
	}
}
