package com.tcowling.eig.ranges;

public class TelephoneNumber implements Comparable {
    private final String number;

    public TelephoneNumber(String number) {
        this.number = number;
    }

    public TelephoneNumber prependNumberWithPrefix(TelephonePrefix telephonePrefix) {
        return null;
    }

    @Override
    public int compareTo(Object comparisonObject) {
        TelephoneNumber comparisonTelephoneNumber = (TelephoneNumber) comparisonObject;
        if (this.equals(comparisonObject)) {
            return 0;
        } else if (this.lessThan(comparisonTelephoneNumber)) {
            return -1;
        } else {
            return 1;
        }
    }

    public Boolean lessThan(TelephoneNumber anotherTelephoneNumber) {
        long numericTelephoneOfFirst = Long.valueOf(number);
        long numericTelephoneOfSecond = Long.valueOf(anotherTelephoneNumber.number);

        return numericTelephoneOfFirst < numericTelephoneOfSecond;
    }

    public Boolean greaterThan(TelephoneNumber anotherTelephoneNumber) {
        long numericTelephoneOfFirst = Long.valueOf(number);
        long numericTelephoneOfSecond = Long.valueOf(anotherTelephoneNumber.number);

        return numericTelephoneOfFirst > numericTelephoneOfSecond;
    }

    @Override
    public String toString() {
        return "TelephoneNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
