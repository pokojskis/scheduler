package com.sektorsoftware.schoolscheduler.util;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class AbstractTest {

    public EasyRandomParameters parameters;

    public EasyRandom generator = new EasyRandom();

    public void createParameters() {
        parameters.stringLengthRange(3, 3);
        parameters.collectionSizeRange(2, 5);
    }
}
