package com.github.brymck.getlocalendpoint;

import java.net.URI;
import java.net.URISyntaxException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class allows retrieving service endpoints from environment variables.
 *
 * <p>For example, suppose the environment variable {@code FOO_ADDRESS} should contain the route to
 * a service in the form {@code "host:port"}:
 *
 * <pre>{@code
 * String fooEndpoint = getHttpEndpoint("FOO_ADDRESS");
 * SomeApi api = new SomeApi(fooEndpoint);
 * }</pre>
 *
 * @author Bryan McKelvey
 */
public class GetLocalEndpoint {
  private static Logger logger = LoggerFactory.getLogger(GetLocalEndpoint.class);

  /**
   * Retrieves an HTTP endpoint from an environment variable.
   *
   * @param name the environment variable's name
   * @return a string containing the path to an HTTP endpoint, or {@code null} if the environment
   *     variable has no value or errors were encountered constructing the URI
   */
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
