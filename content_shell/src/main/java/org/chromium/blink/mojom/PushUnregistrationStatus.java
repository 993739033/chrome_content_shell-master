package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class PushUnregistrationStatus {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NETWORK_ERROR = 7;
  public static final int NO_SERVICE_WORKER = 3;
  public static final int PENDING_NETWORK_ERROR = 2;
  public static final int PENDING_SERVICE_ERROR = 5;
  public static final int SERVICE_NOT_AVAILABLE = 4;
  public static final int STORAGE_ERROR = 6;
  public static final int SUCCESS_UNREGISTERED = 0;
  public static final int SUCCESS_WAS_NOT_REGISTERED = 1;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 7;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private PushUnregistrationStatus() {}
}
