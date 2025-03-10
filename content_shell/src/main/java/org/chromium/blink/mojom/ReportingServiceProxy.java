package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public interface ReportingServiceProxy extends Interface {
  public static final Interface.Manager<ReportingServiceProxy, Proxy> MANAGER =
      ReportingServiceProxy_Internal.MANAGER;

  public interface Proxy extends ReportingServiceProxy, Interface.Proxy {}

  void queueCspViolationReport(
      Url url,
      String str,
      String str2,
      String str3,
      String str4,
      String str5,
      String str6,
      String str7,
      String str8,
      String str9,
      short s,
      int i,
      int i2);

  void queueDeprecationReport(
      Url url, String str, Time time, String str2, String str3, int i, int i2);

  void queueDocumentPolicyViolationReport(
      Url url, String str, String str2, String str3, String str4, String str5, int i, int i2);

  void queueInterventionReport(Url url, String str, String str2, String str3, int i, int i2);

  void queuePermissionsPolicyViolationReport(
      Url url, String str, String str2, String str3, String str4, String str5, int i, int i2);
}
