package com.ejb3unit.sessionbeantests;
import com.bm.testsuite.BaseSessionBeanFixture;
import com.ejb3unit.AnnotatedMethodsSessionBean;
import com.ejb3unit.StockWKNBo;

/**
 * This test test the injection using setter methods, as defined in chapter
 * *.1.2 of the ejb3 specification 
 * <code>
 * @Resource(name=”customerDB”)
 * public void setDataSource(DataSource myDB) {
 * </code>
 * 
 * @author Daniel Wiese
 */
public class DIMethodSessionBeanTest extends
		BaseSessionBeanFixture<AnnotatedMethodsSessionBean> {

	private static final Class[] usedBeans = { StockWKNBo.class };

	/**
	 * Constructor.
	 */
	public DIMethodSessionBeanTest() {
		super(AnnotatedMethodsSessionBean.class, usedBeans);
	}

	/**
	 * Test the dpendency injection.
	 * 
	 * @author Daniel Wiese
	 * @since 08.11.2005
	 */
	public void testDependencyInjection() {
		final AnnotatedMethodsSessionBean toTest = this.getBeanToTest();
		assertNotNull(toTest);
		assertNotNull(toTest.getDs());
		assertNotNull(toTest.getManager());
		assertNotNull(toTest.getMySessionBean());
		assertNotNull(toTest.getTimer());
	}
	
	/**
	 * Test the dpendency injection.
	 * 
	 * @author Daniel Wiese
	 * @since 08.11.2005
	 */
	public void testDependencyInjectionWithMethodInvokation() {
		final AnnotatedMethodsSessionBean toTest = this.getBeanToTest();
		toTest.executeOperation();
	}

	

}
