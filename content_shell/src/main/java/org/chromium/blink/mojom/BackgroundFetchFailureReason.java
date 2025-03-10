package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BackgroundFetchFailureReason {
  public static final int BAD_STATUS = 3;
  public static final int CANCELLED_BY_DEVELOPER = 2;
  public static final int CANCELLED_FROM_UI = 1;
  public static final int DOWNLOAD_TOTAL_EXCEEDED = 7;
  public static final int FETCH_ERROR = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NONE = 0;
  public static final int QUOTA_EXCEEDED = 6;
  public static final int SERVICE_WORKER_UNAVAILABLE = 5;

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

  private BackgroundFetchFailureReason() {}
}
