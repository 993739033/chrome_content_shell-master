package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class CookieDeletionSessionControl {
  public static final int IGNORE_CONTROL = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int PERSISTENT_COOKIES = 2;
  public static final int SESSION_COOKIES = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private CookieDeletionSessionControl() {}
}
