package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CodecType {
  public static final int ANY = 0;
  public static final int SECURE = 1;
  public static final int SOFTWARE = 2;
}
