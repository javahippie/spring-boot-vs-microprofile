# Spring Boot vs. Eclipse MicroProfile Comparison

## Intent
This is a demo Repository for my Talk  ["Getting back in the ring! Comparing Eclipse Microprofile to Spring Boot"](https://sessionize.com/s/tim-zoller/getting_back_in_the_ring_comparing_/22395). The slides can be found here: https://speakerdeck.com/javahippie/getting-back-in-the-ring-comparing-eclipse-microprofile-to-spring-boot. This repository does not show all technologies of either stack, the services are simplified and do not implement a thorough error handling.

## Structure
This repository contains three projects, each containing one service.

### Customer Service
A small Service exposing customer Data over HTTP. 

### Order Service (Spring Boot)
A service to create new orders for customers, using the customer service to gather data.

### Complaint Service (Microprofile)
A service to register customer complaints, using the customer service and the order service
