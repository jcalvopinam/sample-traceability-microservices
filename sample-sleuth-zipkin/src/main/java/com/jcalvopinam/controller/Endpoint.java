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

package com.jcalvopinam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class Endpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(Endpoint.class);
    private static final String URL_SAMPLE_DUMMY_MS_1_API_RANDOM_NUMBERS = "http://localhost:8080/sample_dummy_ms_1/api/random_numbers";
    private static final String URL_SAMPLE_DUMMY_MS_1_API_RANDOM_WORDS = "http://localhost:8080/sample_dummy_ms_1/api/random_words";

    private final RestTemplate restTemplate;

    @Autowired
    public Endpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String welcome() {
        LOGGER.info("Hello Sleuth");
        return "Welcome to Sleuth home page";
    }

    @GetMapping("/random_numbers")
    public ResponseEntity<Integer> getRandomNumbers() {
        LOGGER.info("Getting random numbers");
        return restTemplate.exchange(URL_SAMPLE_DUMMY_MS_1_API_RANDOM_NUMBERS, HttpMethod.GET, null,
                                     Integer.class, 1L);
    }

    @GetMapping("/random_words")
    public ResponseEntity<String> getRandomWords() {
        LOGGER.info("Getting random words");
        return restTemplate.exchange(URL_SAMPLE_DUMMY_MS_1_API_RANDOM_WORDS, HttpMethod.GET, null,
                                     String.class, 1L);
    }

}