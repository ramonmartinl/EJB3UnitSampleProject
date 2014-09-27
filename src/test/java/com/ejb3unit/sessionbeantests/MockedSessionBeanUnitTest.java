package com.ejb3unit.sessionbeantests;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.jmock.Expectations;
import org.jmock.Mockery;

import com.bm.testsuite.mocked.MockedSessionBeanFixture;
import com.ejb3unit.AnnotatedFieldSessionBean;
import com.ejb3unit.IMySessionBean;

/**
 * Testcase for testng session beans as mocked objects.
 * 
 * @author Daniel Wiese 
 * 
 */
public class MockedSessionBeanUnitTest extends MockedSessionBeanFixture<AnnotatedFieldSessionBean> {

	private static final class MockedDataSource implements DataSource {
		public Connection getConnection() throws SQLException {
			return null;
		}

		public Connection getConnection(String arg0, String arg1)
				throws SQLException {
			return null;
		}

		public PrintWriter getLogWriter() throws SQLException {
			return null;
		}

		public void setLogWriter(PrintWriter arg0) throws SQLException {
		
		}

		public void setLoginTimeout(int arg0) throws SQLException {
		
		}

		public int getLoginTimeout() throws SQLException {
			return 0;
		}

		public boolean isWrapperFor(Class<?> arg0) throws SQLException {
			return false;
		}

		public <T> T unwrap(Class<T> arg0) throws SQLException {
			return null;
		}

		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			// TODO Auto-generated method stub
			return null;
		}
	}

	/**
	 * Constructor.
	 */
	public MockedSessionBeanUnitTest() {
		super(AnnotatedFieldSessionBean.class);
	}

	/**
	 * Testmethod.
	 */
	public void test_executeOperation() {
		AnnotatedFieldSessionBean sUT = this.getBeanToTest();
		assertNotNull(sUT);
		Mockery context = new Mockery();
		final IMySessionBean mockMySessionBean = context.mock(IMySessionBean.class);
		assertNotNull(mockMySessionBean);
		sUT.setMySessionBean(mockMySessionBean);
		
		final DataSource ds = new MockedDataSource();
		// instrument mock
		context.checking(new Expectations() {{
		    one (mockMySessionBean).getDs(); will(returnValue(ds));
		}});

		// call the expected operation
		sUT.executeOperation();

	}

}
