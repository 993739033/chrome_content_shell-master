package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BackgroundFetchError {
  public static final int DUPLICATED_DEVELOPER_ID = 1;
  public static final int INVALID_ARGUMENT = 2;
  public static final int INVALID_ID = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 8;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int PERMISSION_DENIED = 7;
  public static final int QUOTA_EXCEEDED = 6;
  public static final int REGISTRATION_LIMIT_EXCEEDED = 8;
  public static final int SERVICE_WORKER_UNAVAILABLE = 5;
  public static final int STORAGE_ERROR = 4;

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

  private BackgroundFetchError() {}
}
