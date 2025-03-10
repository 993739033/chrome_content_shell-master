package org.chromium.content_public.browser.navigation_controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface UserAgentOverrideOption {
  public static final int FALSE = 1;
  public static final int INHERIT = 0;
  public static final int TRUE = 2;
}
