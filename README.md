# Spring Boot vs. Eclipse MicroProfile Comparison

## Intent
This is a demo Repository for my Talk  ["Getting back in the ring! Comparing Eclipse Microprofile to Spring Boot"](https://sessionize.com/s/tim-zoller/getting_back_in_the_ring_comparing_/22395). The slides will be attached here, as soon as they are finished

## Structure
This repository contains three projects, each containing one service.

### de.javahippie.backinthering.complaint.customer.Customer Service
A small Service exposing customer Data over HTTP. 

### Order Service
A service to create new orders for customers, using the customer service to gather data.

### Complaint Service
A service to register customer complaints, using the customer service and the order service

