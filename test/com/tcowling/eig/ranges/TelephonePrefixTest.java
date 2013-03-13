package com.tcowling.eig.ranges;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TelephonePrefixTest {
    @Test
    public void shouldCheckForValidPrefix() throws Exception {
        TelephonePrefix validTelephonePrefix = new TelephonePrefix("+123");
        TelephonePrefix invalidTelephonePrefix = new TelephonePrefix("+324324897");
        
        assertThat("Number component less than 3 should be valid", validTelephonePrefix.isValid(), is(true));
        assertThat("Number component greater than 3 should be invalid", invalidTelephonePrefix.isValid(), is(false));
    }
    
    @Test
    public void shouldIgnoreWhetherUserSpecifiedPlusOrNot() throws Exception {
        TelephonePrefix unspecifiedPlusPrefix = new TelephonePrefix("123");
        TelephonePrefix specifiedPlusPrefix = new TelephonePrefix("+123");
        TelephonePrefix tooManySpecifiedPlussesPrefix = new TelephonePrefix("++123");

        assertThat("Prefix should contain plus and number", unspecifiedPlusPrefix.getPrefix(), is("123"));
        assertThat("Prefix should contain plus and number", specifiedPlusPrefix.getPrefix(), is("123"));
        assertThat("Prefix should contain plus and number", tooManySpecifiedPlussesPrefix.getPrefix(), is("123"));
    }
}
