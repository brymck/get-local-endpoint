package com.github.brymck.getlocalendpoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GetLocalEndpoint")
class GetLocalEndpointTest {
  @Test
  @DisplayName("instantiates an instance of GetLocalEndpoint")
  void instantiatesAnInstanceOfGetLocalEndpoint() {
    // This test is pretty meaningless because the methods are all static, but it's included for
    // code coverage purposes
    assertDoesNotThrow(GetLocalEndpoint::new);
  }
}
