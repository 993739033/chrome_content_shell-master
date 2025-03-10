package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PrivateNetworkAccessPreflightResult {
  public static final int ERROR = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 3;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int SUCCESS = 1;
  public static final int WARNING = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 3;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PrivateNetworkAccessPreflightResult() {}
}
