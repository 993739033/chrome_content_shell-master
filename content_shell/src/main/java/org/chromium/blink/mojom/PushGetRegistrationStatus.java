package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PushGetRegistrationStatus {
  public static final int INCOGNITO_REGISTRATION_NOT_FOUND = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NO_LIVE_SERVICE_WORKER = 8;
  public static final int REGISTRATION_NOT_FOUND = 3;
  public static final int RENDERER_SHUTDOWN = 7;
  public static final int SERVICE_NOT_AVAILABLE = 1;
  public static final int STORAGE_CORRUPT = 6;
  public static final int STORAGE_ERROR = 2;
  public static final int SUCCESS = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 6:
      case 7:
      case 8:
        return true;
      case 5:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PushGetRegistrationStatus() {}
}
