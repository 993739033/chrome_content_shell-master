package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SmartCardShareMode {
  public static final int DIRECT = 2;
  public static final int EXCLUSIVE = 1;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int SHARED = 0;

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

  private SmartCardShareMode() {}
}
