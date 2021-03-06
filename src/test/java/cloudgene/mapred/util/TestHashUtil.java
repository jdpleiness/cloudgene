package cloudgene.mapred.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestHashUtil {

    @Test
    public void testBCryptHash() {
        String password = "P@assW0rd!Test";
        String passwordHash = HashUtil.hashPassword(password);
        assertTrue("Candidate password should match stored hash:",
                HashUtil.checkPassword(password, passwordHash));
    }

   /* @Test
    public void testMD5Hash() {
        String password = "P@assW0rd!Test";
        String passwordHash = HashUtil.getMD5(password);
        assertEquals("Generated MD5 hash should match",
                "801f65f0fb7f4417b2e2cc5490c88cc3", passwordHash);
    }*/
}
