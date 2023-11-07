/*
 * Unit Testing for Sprint 1:
 * Testing includes: 
 *      - create user account
 *      - login
 *      - logout
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class sprintUnitTest {
    private User testSubject;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new User();
    }

    @After
        public void tearDown() throws Exception {
        testSubject = null;
    }
    
    @Test
    public void testLogin() {
        // Test Login
        testSubject = testSubject.loginUser("sysadmin1", "sysadmin1");
        assertEquals("Login System Admin", 10001, testSubject.getEmpID());
        testSubject = testSubject.loginUser("staff1", "staff1");
        assertEquals("Login Cafe Staff", 10004, testSubject.getEmpID());
        testSubject = testSubject.loginUser("notaUser", "notaUser");
        assertEquals("Login Fail", 0, testSubject.getEmpID());
        testSubject = testSubject.loginUser("notaUser2", "notaUser2");
        assertEquals("Login Fail", 0, testSubject.getEmpID());
    }
}