package com.tcowling.eig.ranges;

import com.google.common.collect.Range;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RangeTests {
    @Test
    public void shouldCheckTelephoneNumberIsInRange() {
        TelephoneNumber testNumber1 = new TelephoneNumber("100");
        TelephoneNumber testNumber2 = new TelephoneNumber("200");

        Range<TelephoneNumber> range = Range.closed(testNumber1, testNumber2);
        Range<TelephoneNumber> rangeWithRightOpen = Range.closedOpen(testNumber1, testNumber2);

        assertThat(range.contains(testNumber2), is(true));
        assertThat(rangeWithRightOpen.contains(testNumber2), is(false));
    }
}
