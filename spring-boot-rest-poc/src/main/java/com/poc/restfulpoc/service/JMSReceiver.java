/**
 * Copyright (c) Raja Dilip Chowdary Kolli. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.poc.restfulpoc.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.poc.restfulpoc.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JMSReceiver {

    private final CustomerRepository customerRepository;

    @JmsListener(destination = "jms.message.endpoint")
    public void receiveMessage(String customerId) {
        log.info("Received CustomerID:{} for deletion", customerId);
        customerRepository.deleteById(Long.valueOf(customerId));
    }
}
