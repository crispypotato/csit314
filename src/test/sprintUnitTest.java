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
    private loginController testSubject2;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new User();
        this.testSubject2 = new loginController();
    }

    @After
        public void tearDown() throws Exception {
        testSubject = null;
        testSubject2 = null;
    }
    
    @Test
    public void testEntityLogin() {
        // Test Login - Expected Success
        testSubject = testSubject.loginUser("sysadmin1", "sysadmin1");
        assertEquals("Login SA E", 10001, testSubject.getEmpID());
        testSubject = testSubject.loginUser("staff1", "staff1");
        assertEquals("Login CS E", 10004, testSubject.getEmpID());
        // Test Login - Expected Failure
        testSubject = testSubject.loginUser("notaUser", "notaUser");
        assertEquals("Login Fail E", 0, testSubject.getEmpID());
        testSubject = testSubject.loginUser("notaUser2", "notaUser2");
        assertEquals("Login Fail E2", 0, testSubject.getEmpID());
    }

    @Test
    public void testControllerLogin() {
        // Test Login - Expected Success
        testSubject = testSubject2.loginUser("sysadmin1","sysadmin1");
        assertEquals("Login SA C", 10001, testSubject.getEmpID());
        testSubject = testSubject2.loginUser("staff1", "staff1");
        assertEquals("Login CS C", 10004, testSubject.getEmpID());
        // Test Login - Expected Failure
        testSubject = testSubject2.loginUser("notaUser", "notaUser");
        assertEquals("Login Fail C", 0, testSubject.getEmpID());
        testSubject = testSubject2.loginUser("notaUser2", "notaUser2");
        assertEquals("Login Fail C2", 0, testSubject.getEmpID());
    }

    @Test
    public void testEntityCreateUser() {
        // Test Create User - Expected Success
    }
}