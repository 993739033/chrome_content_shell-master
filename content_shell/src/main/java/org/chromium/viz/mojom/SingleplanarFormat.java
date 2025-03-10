package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class SingleplanarFormat {
  public static final int ALPHA_8 = 3;
  public static final int BGRA_8888 = 2;
  public static final int BGRX_1010102 = 17;
  public static final int BGRX_8888 = 15;
  public static final int BGR_565 = 6;
  public static final int ETC1 = 7;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int LUMINANCE_8 = 4;
  public static final int LUMINANCE_F16 = 10;
  public static final int MAX_VALUE = 22;
  public static final int MIN_VALUE = 0;
  public static final int NV12A_LEGACY = 21;
  public static final int NV12_LEGACY = 20;
  public static final int P010_LEGACY = 22;
  public static final int R16_EXT = 12;
  public static final int RED_8 = 8;
  public static final int RG16_EXT = 13;
  public static final int RGBA_4444 = 1;
  public static final int RGBA_8888 = 0;
  public static final int RGBA_F16 = 11;
  public static final int RGBX_1010102 = 16;
  public static final int RGBX_8888 = 14;
  public static final int RGB_565 = 5;
  public static final int RG_88 = 9;
  public static final int R_F16 = 18;
  public static final int YV12_LEGACY = 19;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 22;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private SingleplanarFormat() {}
}
