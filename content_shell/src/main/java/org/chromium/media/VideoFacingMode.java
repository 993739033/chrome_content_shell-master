package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoFacingMode {
  public static final int MEDIA_VIDEO_FACING_ENVIRONMENT = 2;
  public static final int MEDIA_VIDEO_FACING_NONE = 0;
  public static final int MEDIA_VIDEO_FACING_USER = 1;
  public static final int NUM_MEDIA_VIDEO_FACING_MODES = 3;
}
