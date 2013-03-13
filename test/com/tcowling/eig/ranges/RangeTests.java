package com.tcowling.eig.ranges;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RangeTests {
    private TelephoneNumber startNumber;
    private TelephoneNumber endNumber;
    private Range<TelephoneNumber> smallerRange;
    private Range<TelephoneNumber> largerRange;
    private TelephoneNumber firstTelephoneNumberWithinRange;
    private TelephoneNumber secondTelephoneNumberWithinRange;

    @Before
    public void setup() {
        startNumber = new TelephoneNumber("100");
        endNumber = new TelephoneNumber("200");
        firstTelephoneNumberWithinRange = new TelephoneNumber("150");
        secondTelephoneNumberWithinRange = new TelephoneNumber("175");
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

        Range<TelephoneNumber> smallRange = Range.closed(firstTelephoneNumberWithinRange, secondTelephoneNumberWithinRange);

        assertThat("Smaller range should be enclosed by larger range", largerRange.encloses(smallRange), equalTo(true));
    }
    
    @Test
    public void shouldCheckThatAListOfTelephoneNumbersAreContainedWithinTheRange() {
        Range<TelephoneNumber> range = Range.closed(startNumber, endNumber);

        ArrayList<TelephoneNumber> someTelephoneNumbers = Lists.newArrayList(firstTelephoneNumberWithinRange, secondTelephoneNumberWithinRange);

        assertThat(range.containsAll(someTelephoneNumbers), is(true));
    }
    
    @Test
    public void shouldCreateRangeForGiveTelephoneNumbers() {
        ArrayList<TelephoneNumber> numbers = Lists.newArrayList(startNumber, firstTelephoneNumberWithinRange, secondTelephoneNumberWithinRange, endNumber);
        Range<TelephoneNumber> range = Range.encloseAll(numbers);
        
        assertThat(range.lowerEndpoint(), equalTo(startNumber));
        assertThat(range.upperEndpoint(), equalTo(endNumber));
    }
}
