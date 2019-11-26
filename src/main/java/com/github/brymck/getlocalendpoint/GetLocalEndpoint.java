package com.github.brymck.getlocalendpoint;

import java.net.URI;
import java.net.URISyntaxException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class allows executing a code block with a modified system environment.
 *
 * <p>For example:
 *
 * <pre>{@code
 * Map<String, String> overrides = new HashMap();
 * overrides.put("FOO", "bar");
 * WithEnvironment.withEnvironmentOverrides(overrides, () -> {
 *   String foo = System.getenv("FOO");
 *   System.out.println(foo);  // prints "bar"
 * });
 * }</pre>
 *
 * @author Bryan McKelvey
 */
public class GetLocalEndpoint {
  private static Logger logger = LoggerFactory.getLogger(GetLocalEndpoint.class);

  public static @Nullable String getHttpEndpoint(@NotNull String name) {
    String address = System.getenv(name);
    if (address == null) {
      return null;
    }
    String[] parts = address.split(":");
    String host = parts[0];
    URI uri;
    try {
      if (parts.length > 1) {
        int port = Integer.parseInt(parts[1]);
        uri = new URI("http", null, host, port, null, null, null);
      } else {
        uri = new URI("http", host, null, null);
      }
    } catch (URISyntaxException e) {
      String message =
          "Could not build URI from environment variable \""
              + name
              + "\" with value \""
              + address
              + "\"";
      logger.warn(message, e);
      return null;
    }

    return uri.toString();
  }
}
