package com.ejb3unit.entitytests;

import com.bm.testsuite.BaseEntityFixture;
import com.ejb3unit.StockWKNBo;

/**
 * This is an axample for fully automated entity bean testing. Beans are randomly
 * generated and written to an in momory database. Equals and hashcode
 * imlementations will be automatically checked. 
 * 
 * @author Daniel Wiese
 * @since 15.10.2006
 */
public class StockWKNBoTest extends BaseEntityFixture<StockWKNBo> {

	/**
	 * Constructor.
	 */
	public StockWKNBoTest() {
		super(StockWKNBo.class);
	}

}
