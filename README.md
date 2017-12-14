# Contacts API Java SDK

[![Bintray](https://img.shields.io/bintray/v/fullcontact/fullcontact-oss/contacts-api-java.svg)](https://bintray.com/fullcontact/fullcontact-oss/contacts-api-java)
[![Build Status](https://travis-ci.org/fullcontact/contacts-api-java.svg?branch=master)](https://travis-ci.org/fullcontact/contacts-api-java)

Java SDK for [FullContact Contacts API](https://www.fullcontact.com/apps/docs)

### Installation

Maven
```
<dependency>
  <groupId>com.fullcontact</groupId>
  <artifactId>contacts-api-java</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency>
```

Gradle
```
compile 'com.fullcontact:contacts-api-java:1.0.2'
```


### Documentation

API Documentation can be found at [https://www.fullcontact.com/apps/docs](https://www.fullcontact.com/apps/docs)

### Usage

##### Getting Started
---

```
package com.fullcontact.example;

import com.fullcontact.contacts.api;

public class APITest {
    ContactsAPIClient client = new ContactsAPIClient("<client_id>", "<client_secret>");
}
```

#### Tests
---

To run tests:

`./gradlew test`