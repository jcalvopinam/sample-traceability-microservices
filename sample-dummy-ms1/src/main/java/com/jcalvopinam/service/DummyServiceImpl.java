/*
 * MIT License
 *
 * Copyright (c) 2018. JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@Service
public class DummyServiceImpl implements DummyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DummyServiceImpl.class);

    private Random random = new Random();

    @Override
    public Integer generateRandomNumbers() {
        LOGGER.info("Generating a new random number");
        return Math.abs(random.nextInt());
    }

    @Override
    public String generateRandomWords() {
        LOGGER.info("Generating a new random word");
        int endExclusive = 5;
        String[] randomStrings = new String[endExclusive];

        int startInclusive = 0;
        IntStream.range(startInclusive, endExclusive)
                 .forEach(i -> {
                     char[] word = new char[random.nextInt(8) + 3];
                     IntStream.range(0, word.length)
                              .forEach(j -> word[j] = (char) ('a' + random.nextInt(26)));
                     randomStrings[i] = new String(word);
                 });
        return Arrays.toString(randomStrings);
    }

}
