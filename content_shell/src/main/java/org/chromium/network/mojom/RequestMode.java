package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RequestMode {
  public static final int CORS = 2;
  public static final int CORS_WITH_FORCED_PREFLIGHT = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 4;
  public static final int MIN_VALUE = 0;
  public static final int NAVIGATE = 4;
  public static final int NO_CORS = 1;
  public static final int SAME_ORIGIN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 4;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RequestMode() {}
}
