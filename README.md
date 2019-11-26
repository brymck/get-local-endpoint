get-local-endpoint
==================

[![CircleCI](https://circleci.com/gh/brymck/get-local-endpoint.svg?style=svg)](https://circleci.com/gh/brymck/get-local-endpoint)
[![codecov](https://codecov.io/gh/brymck/get-local-endpoint/branch/master/graph/badge.svg)](https://codecov.io/gh/brymck/get-local-endpoint)

`get-local-endpoint` is a library that allows retrieving endpoints from environment variables.

This is designed for use cases where the API endpoint is defined via environment variables, which
allows decoupling of service paths from implementation.

A good example of this in action is [Google's microservices demo][microservices-demo], in particular
with the frontend service, which calls the various backend services based on an
[environment-driven configuration][frontend-yaml].

Usage
-----

Include this in your POM:

```xml
<dependency>
  <groupId>com.github.brymck</groupId>
  <artifactId>get-local-endpoint</artifactId>
  <version>0.9.0</version>
</dependency>
```

And use it as so:

```java
String fooEndpoint = getHttpEndpoint("FOO_ADDRESS");
SomeApi api = new SomeApi(fooEndpoint);
```

[microservices-demo]: https://github.com/GoogleCloudPlatform/microservices-demo
[frontend-yaml]: https://github.com/GoogleCloudPlatform/microservices-demo/blob/master/kubernetes-manifests/frontend.yaml
