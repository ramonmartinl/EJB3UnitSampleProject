package com.ejb3unit.sessionbeantests;

import java.util.List;

import com.bm.testsuite.BaseSessionBeanFixture;
import com.bm.testsuite.dataloader.CSVInitialDataSet;
import com.bm.testsuite.dataloader.EntityInitialDataSet;
import com.ejb3unit.MySessionBean;
import com.ejb3unit.StockWKNBo;

/**
 * The Session bean 'integration test' will test a bean using field annotations. The test
 * injects all dependencies (and dependencies of the dependend Beans). Futhermore
 * this test demonstrates how to use CSV datasets to intrument a database with a 
 * well defined set of data.
 * 
 * @author Daniel Wiese
 */
public class DIFieldSessionBeanTest extends BaseSessionBeanFixture<MySessionBean> {

	private static final Class[] usedBeans = { StockWKNBo.class };

	private static final CSVInitialDataSet CSV_SET = new CSVInitialDataSet<StockWKNBo>(
			StockWKNBo.class, "germanStocks.csv", "wkn", "aktienName", "isin",
			"symbol", "kaufModus", "branchenCode", "branche",
			"transaktionenProTag", "zumHandelZugelassen", "volatilitaet",
			"durchschnittskaufkurs");

	/**
	 * Constructor.
	 */
	public DIFieldSessionBeanTest() {
		super(MySessionBean.class, usedBeans,
				new StockWKNEntityInitialDataSet(), CSV_SET);
	}

	/**
	 * Test the dpendency injection.
	 * 
	 * @author Daniel Wiese
	 * @since 08.11.2005
	 */
	public void testDependencyInjection() {
		final MySessionBean toTest = this.getBeanToTest();
		assertNotNull(toTest);
		assertNotNull(toTest.getDs());
		assertNotNull(toTest.getEm());
	}

	/**
	 * Test the dpendency injection.
	 * 
	 * @author Daniel Wiese
	 * @since 08.11.2005
	 */
	public void testLoadData() {
		final MySessionBean toTest = this.getBeanToTest();
		assertNotNull(toTest);
		List<StockWKNBo> back = toTest.getAllStocks();
		assertNotNull(back);
		assertEquals(188, back.size());
		assertEquals(back.get(0), new StockWKNBo(1, "Das ist ein Name"));
		assertEquals(back.get(1), new StockWKNBo(2, "Das ist ein andere Name"));
	}

	/**
	 * Creates a initial data set.
	 * 
	 * @author Daniel Wiese
	 * @since 17.04.2006
	 */
	public static class StockWKNEntityInitialDataSet extends
			EntityInitialDataSet<StockWKNBo> {

		/**
		 * Constructor.
		 * 
		 * @param entityType
		 */
		public StockWKNEntityInitialDataSet() {
			super(StockWKNBo.class);
		}

		/**
		 * Creates the data.
		 * 
		 * @author Daniel Wiese
		 * @since 17.04.2006
		 * @see com.bm.testsuite.dataloader.InitialDataSet#create()
		 */
		public void create() {
			this.add(new StockWKNBo(1, "Das ist ein Name"));
			this.add(new StockWKNBo(2, "Das ist ein andere Name"));

		}

	}

}
