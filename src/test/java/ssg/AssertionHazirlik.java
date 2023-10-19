package ssg;

import org.junit.Assert;
import org.junit.Test;

public class AssertionHazirlik {
    //assert            condition           result
    //  dogru mu ?     false(yanlis)      ==> failed
    //  dogru mu ?     true(dogru)        ==> passed
    //  yanlis mi?     false(yanlis)      ==> passed
    //  yanlis mi?     true(dogru)        ==> failed

    int ehliyetYasi=18;
    int alininYasi=15;
    int ayseninYasi=23;

    @Test
    public void test01() {
        // Ali'nin ehliyet alabileceğini test edin
        Assert.assertTrue("Bu kişi ehliyet alamaz!", alininYasi >= ehliyetYasi);
        //         True                                                         False             == Fail
    }

    @Test
    public void test02() {
        // Ayşe'nin ehliyet alamayacağını test edin
        Assert.assertFalse(ayseninYasi >= ehliyetYasi);
        //         False                      True             == Fail
    }

    @Test
    public void test03() {
        // Ehliyet yaşının 18 olduğunu test edin
        Assert.assertEquals(18, ehliyetYasi);
        //         True               True            == Pass
    }

    @Test
    public void test04() {
        // Ali'nin yaşının Ayşenin yaşından büyük olduğunu test edin.
        Assert.assertTrue(alininYasi > ayseninYasi);
        //         True                    False             == Fail
    }

    @Test
    public void test05() {
        // Ali'nin yaşının Ayşenin yaşından büyük olmadığını test edin.
        Assert.assertFalse(alininYasi > ayseninYasi);
        //         False                     False             == Pass
    }
}
