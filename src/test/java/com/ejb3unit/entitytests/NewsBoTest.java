package com.ejb3unit.entitytests;

import com.bm.datagen.Generator;
import com.bm.datagen.constant.ConstantIntegerGenerator;
import com.bm.testsuite.BaseEntityFixture;
import com.ejb3unit.NewsBo;

/**
 * This is an axample for fully automated entity bean testing. Beans are randomly
 * generated and written to an in momory database. Equals and hashcode
 * imlementations will be automatically checked. 
 * 
 * @author Daniel Wiese
 * @since 15.10.2006
 */
public class NewsBoTest extends BaseEntityFixture<NewsBo> {

	private static final Generator[] SPECIAL_GENERATORS = { new ConstantIntegerGenerator(
			870737) };

	/**
	 * 
	 * Constructor.
	 */
	public NewsBoTest() {
		super(NewsBo.class, SPECIAL_GENERATORS);
	}

}
