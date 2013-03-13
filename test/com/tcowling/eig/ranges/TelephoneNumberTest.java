package com.tcowling.eig.ranges;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TelephoneNumberTest {
    @Test
    public void shouldTestEquality() throws Exception {
        TelephoneNumber firstNumber = new TelephoneNumber("100");
        TelephoneNumber secondNumber = new TelephoneNumber("200");

        assertThat(firstNumber, equalTo(firstNumber));
        assertThat(firstNumber, not(equalTo(secondNumber)));
    }
    
    @Test
    public void shouldTestNumberComparisons() {
        TelephoneNumber firstNumber = new TelephoneNumber("0100");
        TelephoneNumber secondNumber = new TelephoneNumber("0200");

        assertThat("First number (" + firstNumber + ") less than the second (" + secondNumber + ") should be true", firstNumber.lessThan(secondNumber), is(true));
        assertThat("Second number (" + firstNumber + ") less than the first (" + secondNumber + ") should be false", secondNumber.lessThan(firstNumber), is(false));

        assertThat("First number (" + firstNumber + ") greater than the second (" + secondNumber + ") should be true", firstNumber.greaterThan(secondNumber), is(false));
        assertThat("Second number (" + firstNumber + ") greater than the first (" + secondNumber + ") should be false", secondNumber.greaterThan(firstNumber), is(true));
    }
}
