package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SourceEventType {
  public static final int INERTIAL = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int KEY_PRESS = 5;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int MOUSE = 2;
  public static final int OTHER = 8;
  public static final int SCROLLBAR = 7;
  public static final int TOUCH = 3;
  public static final int TOUCHPAD = 6;
  public static final int UNKNOWN = 0;
  public static final int WHEEL = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 8;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SourceEventType() {}
}
