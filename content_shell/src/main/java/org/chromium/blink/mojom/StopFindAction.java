package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class StopFindAction {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int STOP_FIND_ACTION_ACTIVATE_SELECTION = 2;
  public static final int STOP_FIND_ACTION_CLEAR_SELECTION = 0;
  public static final int STOP_FIND_ACTION_KEEP_SELECTION = 1;

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

  private StopFindAction() {}
}
