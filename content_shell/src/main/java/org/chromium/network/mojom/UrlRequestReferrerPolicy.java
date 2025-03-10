package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class UrlRequestReferrerPolicy {
  public static final int CLEAR_REFERRER_ON_TRANSITION_CROSS_ORIGIN = 5;
  public static final int CLEAR_REFERRER_ON_TRANSITION_FROM_SECURE_TO_INSECURE = 0;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 7;
  public static final int MIN_VALUE = 0;
  public static final int NEVER_CLEAR_REFERRER = 3;
  public static final int NO_REFERRER = 7;
  public static final int ORIGIN = 4;
  public static final int ORIGIN_CLEAR_ON_TRANSITION_FROM_SECURE_TO_INSECURE = 6;
  public static final int ORIGIN_ONLY_ON_TRANSITION_CROSS_ORIGIN = 2;
  public static final int REDUCE_REFERRER_GRANULARITY_ON_TRANSITION_CROSS_ORIGIN = 1;

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

  private UrlRequestReferrerPolicy() {}
}
