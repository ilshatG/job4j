package ru.job4j.list;
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CircularReferenceDetectionTest {
    CircularReferenceDetection detect;

    @Before
    public void itit() {
        detect = new CircularReferenceDetection();
    }

    @Test
    public void whenCircularReferenceReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertThat(detect.hasCycle(first), is(true));
    }

    @Test
    public void whenCircularReference3And4ReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = third;

        assertThat(detect.hasCycle(first), is(true));
    }

    @Test
    public void whenCircularReference4And2ReturnTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;

        assertThat(detect.hasCycle(first), is(true));
    }

    @Test
    public void whenAbsentCircularReferenceReturnfalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        assertThat(detect.hasCycle(first), is(false));
    }
}

