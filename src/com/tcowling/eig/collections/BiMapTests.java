package com.tcowling.eig.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BiMapTests {
    private BiMap<Integer,String> bimap;
    @Before
    public void setUp() {
        bimap = HashBiMap.create();
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotAllowToPutExistingValuesInBiMap() {

        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "one");

        fail("Should throw IllegalArgumentException");
    }

    @Test
    public void shouldNotAllowSecondKeyEntry() {
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");
        bimap.put(10, "cna");

        assertThat(bimap.get(1), equalTo("one"));

        bimap.forcePut(10, "one");

        assertThat(bimap.get(10), equalTo("one"));
        assertThat(bimap.get(1), nullValue());
    }
    
    @Test
    public void shouldBeAbleToInverseBiMap() throws Exception {
        bimap.put(1, "one");
        bimap.put(2, "two");
        bimap.put(10, "ten");


    }
}
