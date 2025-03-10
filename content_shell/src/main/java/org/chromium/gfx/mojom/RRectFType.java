package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class RRectFType {
  public static final int COMPLEX = 5;
  public static final int EMPTY = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 5;
  public static final int MIN_VALUE = 0;
  public static final int OVAL = 4;
  public static final int RECT = 1;
  public static final int SIMPLE = 3;
  public static final int SINGLE = 2;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 5;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private RRectFType() {}
}
