package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AssociatedInterface extends Interface {
  public static final Interface.Manager<AssociatedInterface, Proxy> MANAGER =
      AssociatedInterface_Internal.MANAGER;

  public interface Proxy extends AssociatedInterface, Interface.Proxy {}
}
