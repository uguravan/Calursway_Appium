package com.TDD;

import org.testng.annotations.Test;

public class Test12 {

    @Test
    public void testName3() {
        String text="Cart tab, 5 of 5, 2 new notifications";
        String[] split = text.split(",");


        split[2].replace(" new notifications", "").trim();

    }
}
