package com.github.brymck.getlocalendpoint;

import static com.github.brymck.getlocalendpoint.GetLocalEndpoint.getHttpEndpoint;
import static com.github.brymck.withenvironment.WithEnvironment.withEnvironmentOverrides;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.*;

@DisplayName("getHttpEndpoint")
class GetHttpEndpointTest {
  @Test
  @DisplayName("gets HTTP endpoint when host and port are provided")
  void getsHttpEndpointWhenHostAndPortAreProvided() {
    HashMap<String, String> overrides = new HashMap<>();
    overrides.put("FOO_ADDRESS", "foo:1234");
    withEnvironmentOverrides(
        overrides,
        () -> {
          String endpoint = getHttpEndpoint("FOO_ADDRESS");
          assertEquals("http://foo:1234", endpoint);
        });
  }

  @Test
  @DisplayName("gets HTTP endpoint when host alone is provided")
  void getsHttpEndpointWhenHostAloneIsProvided() {
    HashMap<String, String> overrides = new HashMap<>();
    overrides.put("FOO_ADDRESS", "foo");
    withEnvironmentOverrides(
        overrides,
        () -> {
          String endpoint = getHttpEndpoint("FOO_ADDRESS");
          assertEquals("http://foo", endpoint);
        });
  }
}
