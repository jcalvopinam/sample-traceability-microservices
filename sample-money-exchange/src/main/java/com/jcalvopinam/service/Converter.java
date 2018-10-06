package com.jcalvopinam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
public class Converter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Converter.class);

    private static final Double DOLLAR = 1.16;
    private static final Double EURO = 0.86;

    public static Double dollarToEuro(Double dollar) {
        LOGGER.info("Converting DOLLAR to EURO: 1 DOLLAR is 0.86 EURO");
        return dollar * EURO;
    }


    public static Double euroToDollar(Double euro) {
        LOGGER.info("Converting EURO to DOLLAR: 1 EURO is 1.16 dollars");
        return euro * DOLLAR;
    }

}