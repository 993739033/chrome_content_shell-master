package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class ConsoleMessageSource {
  public static final int CONSOLE_API = 3;
  public static final int DEPRECATION = 8;
  public static final int INTERVENTION = 11;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVA_SCRIPT = 1;
  public static final int MAX_VALUE = 12;
  public static final int MIN_VALUE = 0;
  public static final int NETWORK = 2;
  public static final int OTHER = 7;
  public static final int RECOMMENDATION = 12;
  public static final int RENDERING = 5;
  public static final int SECURITY = 6;
  public static final int STORAGE = 4;
  public static final int VIOLATION = 10;
  public static final int WORKER = 9;
  public static final int XML = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 12;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private ConsoleMessageSource() {}
}
