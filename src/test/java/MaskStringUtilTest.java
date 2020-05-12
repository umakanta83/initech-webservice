import com.notification.util.MaskStringUtil;
import org.junit.Test;


import static org.junit.Assert.*;


public class MaskStringUtilTest {


    @Test
    public void maskEmailAdrsOrMobNoWithNull() throws Exception {
        assertEquals("", MaskStringUtil.maskEmailAdrsOrMobNo(null, '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNo() throws Exception {
        assertEquals("u****k@abc.com", MaskStringUtil.maskEmailAdrsOrMobNo("unayak@abc.com", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoDifMaskChar() throws Exception {
        assertEquals("u####k@abc.com", MaskStringUtil.maskEmailAdrsOrMobNo("unayak@abc.com", '#'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithOneLetr() throws Exception {
        assertEquals("*@yahoo.com", MaskStringUtil.maskEmailAdrsOrMobNo("u@yahoo.com", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithNoEmailId() throws Exception {
        assertEquals("@yahoo.com", MaskStringUtil.maskEmailAdrsOrMobNo("@yahoo.com", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithTwoLetr() throws Exception {
        assertEquals("**@yahoo.com", MaskStringUtil.maskEmailAdrsOrMobNo("uk@yahoo.com", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithEmptyEmail() throws Exception {
        assertEquals("@yahoo.com", MaskStringUtil.maskEmailAdrsOrMobNo("@yahoo.com", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithValidMob() throws Exception {
        assertEquals("123***7890", MaskStringUtil.maskEmailAdrsOrMobNo("1234567890", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithDashMobNo() throws Exception {
        assertEquals("123-***-8905", MaskStringUtil.maskEmailAdrsOrMobNo("123-567-8905", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithSpaceMobNo() throws Exception {
        assertEquals("123 567 8905", MaskStringUtil.maskEmailAdrsOrMobNo("123 567 8905", '*'));
    }

    @Test
    public void maskEmailAdrsOrMobNoWithInvalidMobNo() throws Exception {
        assertEquals("123", MaskStringUtil.maskEmailAdrsOrMobNo("123", '*'));
    }



}
