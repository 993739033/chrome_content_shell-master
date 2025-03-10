package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BarcodeFormat {
  public static final int AZTEC = 0;
  public static final int CODABAR = 4;
  public static final int CODE_128 = 1;
  public static final int CODE_39 = 2;
  public static final int CODE_93 = 3;
  public static final int DATA_MATRIX = 5;
  public static final int EAN_13 = 6;
  public static final int EAN_8 = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int ITF = 8;
  public static final int MAX_VALUE = 13;
  public static final int MIN_VALUE = 0;
  public static final int PDF417 = 9;
  public static final int QR_CODE = 10;
  public static final int UNKNOWN = 11;
  public static final int UPC_A = 12;
  public static final int UPC_E = 13;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 13;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private BarcodeFormat() {}
}
