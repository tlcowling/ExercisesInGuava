package com.tcowling.eig.ranges;

public class TelephonePrefix {
    private static final int MAXIMUM_VALID_PREFIX = 3;

    private String prefix;

    public TelephonePrefix(String prefix) {
        this.prefix = prefix.replace("+", "");
    }

    public Boolean isValid() {
        return (prefix.length() <= MAXIMUM_VALID_PREFIX);
    }

    public String getPrefix() {
        return prefix;
    }
}
