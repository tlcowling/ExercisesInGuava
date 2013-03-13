package com.tcowling.eig.ranges;

import com.google.common.collect.Range;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RangeTests {
    private TelephoneNumber startNumber;
    private TelephoneNumber endNumber;
    private Range<TelephoneNumber> smallerRange;
    private Range<TelephoneNumber> largerRange;

    @Before
    public void setup() {
        startNumber = new TelephoneNumber("100");
        endNumber = new TelephoneNumber("200");
        smallerRange = Range.closed(startNumber, endNumber);
    }

    @Test
    public void shouldCheckInclusiveTelephoneNumberInRange() {
        assertThat("Inclusive range should include " + startNumber, smallerRange.contains(startNumber), is(true));
    }

    @Test
    public void shouldCheckClosedRangeDoesNotIncludeTelephoneNumber() {
        Range<TelephoneNumber> rangeWithEndOpen = Range.closedOpen(startNumber, endNumber);
        Range<TelephoneNumber> rangeWithStartOpen = Range.openClosed(startNumber, endNumber);
        assertThat("Start open range should not include " + startNumber, rangeWithStartOpen.contains(startNumber), is(false));
        assertThat("End open range should not include " + endNumber, rangeWithEndOpen.contains(endNumber), is(false));
    }

    @Test
    public void shouldCheckSmallerTelephoneRangeEnclosedByLargerOne() {
        largerRange = Range.closed(startNumber, endNumber);

        TelephoneNumber smallRangeStartNumber = new TelephoneNumber("150");
        TelephoneNumber smallRangeEndNumber = new TelephoneNumber("175");
        Range<TelephoneNumber> smallRange = Range.closed(smallRangeStartNumber, smallRangeEndNumber);

        assertThat("Smaller range should be enclosed by larger range", largerRange.encloses(smallRange), equalTo(true));
    }
    
    @Test
    public void shouldCheckThatAListOfTelephoneNumbersAreContainedWithinTheRange() {
        assertThat(false, is(true));
    }
}
