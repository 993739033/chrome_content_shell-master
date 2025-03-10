// PaymentRequestEventData.java is auto generated by mojom_bindings_generator.py, do not edit

// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/payments/payment_app.mojom
//

package org.chromium.payments.mojom;

public final class PaymentRequestEventData extends org.chromium.mojo.bindings.Struct {

  private static final int STRUCT_SIZE = 88;
  private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
      new org.chromium.mojo.bindings.DataHeader[] {
        new org.chromium.mojo.bindings.DataHeader(88, 0)
      };
  private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
  public org.chromium.url.mojom.Url topOrigin;
  public org.chromium.url.mojom.Url paymentRequestOrigin;
  public String paymentRequestId;
  public PaymentMethodData[] methodData;
  public PaymentCurrencyAmount total;
  public PaymentDetailsModifier[] modifiers;
  public String instrumentKey;
  public PaymentOptions paymentOptions;
  public PaymentShippingOption[] shippingOptions;
  public PaymentHandlerHost paymentHandlerHost;

  private PaymentRequestEventData(int version) {
    super(STRUCT_SIZE, version);
  }

  public PaymentRequestEventData() {
    this(0);
  }

  public static PaymentRequestEventData deserialize(org.chromium.mojo.bindings.Message message) {
    return decode(new org.chromium.mojo.bindings.Decoder(message));
  }

  /**
   * Similar to the method above, but deserializes from a |ByteBuffer| instance.
   *
   * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
   */
  public static PaymentRequestEventData deserialize(java.nio.ByteBuffer data) {
    return deserialize(
        new org.chromium.mojo.bindings.Message(
            data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
  }

  @SuppressWarnings("unchecked")
  public static PaymentRequestEventData decode(org.chromium.mojo.bindings.Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    PaymentRequestEventData result;
    try {
      org.chromium.mojo.bindings.DataHeader mainDataHeader =
          decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      final int elementsOrVersion = mainDataHeader.elementsOrVersion;
      result = new PaymentRequestEventData(elementsOrVersion);
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
        result.topOrigin = org.chromium.url.mojom.Url.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
        result.paymentRequestOrigin = org.chromium.url.mojom.Url.decode(decoder1);
      }
      {
        result.paymentRequestId = decoder0.readString(24, false);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
        {
          org.chromium.mojo.bindings.DataHeader si1 =
              decoder1.readDataHeaderForPointerArray(
                  org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
          result.methodData = new PaymentMethodData[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {

            org.chromium.mojo.bindings.Decoder decoder2 =
                decoder1.readPointer(
                    org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                        + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1,
                    false);
            result.methodData[i1] = PaymentMethodData.decode(decoder2);
          }
        }
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
        result.total = PaymentCurrencyAmount.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
        {
          org.chromium.mojo.bindings.DataHeader si1 =
              decoder1.readDataHeaderForPointerArray(
                  org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
          result.modifiers = new PaymentDetailsModifier[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {

            org.chromium.mojo.bindings.Decoder decoder2 =
                decoder1.readPointer(
                    org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                        + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1,
                    false);
            result.modifiers[i1] = PaymentDetailsModifier.decode(decoder2);
          }
        }
      }
      {
        result.instrumentKey = decoder0.readString(56, false);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
        result.paymentOptions = PaymentOptions.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, true);
        if (decoder1 == null) {
          result.shippingOptions = null;
        } else {
          org.chromium.mojo.bindings.DataHeader si1 =
              decoder1.readDataHeaderForPointerArray(
                  org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
          result.shippingOptions = new PaymentShippingOption[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {

            org.chromium.mojo.bindings.Decoder decoder2 =
                decoder1.readPointer(
                    org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                        + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1,
                    false);
            result.shippingOptions[i1] = PaymentShippingOption.decode(decoder2);
          }
        }
      }
      {
        result.paymentHandlerHost =
            decoder0.readServiceInterface(80, true, PaymentHandlerHost.MANAGER);
      }

    } finally {
      decoder0.decreaseStackDepth();
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
    org.chromium.mojo.bindings.Encoder encoder0 =
        encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

    encoder0.encode(this.topOrigin, 8, false);

    encoder0.encode(this.paymentRequestOrigin, 16, false);

    encoder0.encode(this.paymentRequestId, 24, false);

    if (this.methodData == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      org.chromium.mojo.bindings.Encoder encoder1 =
          encoder0.encodePointerArray(
              this.methodData.length,
              32,
              org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
      for (int i0 = 0; i0 < this.methodData.length; ++i0) {

        encoder1.encode(
            this.methodData[i0],
            org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0,
            false);
      }
    }

    encoder0.encode(this.total, 40, false);

    if (this.modifiers == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      org.chromium.mojo.bindings.Encoder encoder1 =
          encoder0.encodePointerArray(
              this.modifiers.length,
              48,
              org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
      for (int i0 = 0; i0 < this.modifiers.length; ++i0) {

        encoder1.encode(
            this.modifiers[i0],
            org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0,
            false);
      }
    }

    encoder0.encode(this.instrumentKey, 56, false);

    encoder0.encode(this.paymentOptions, 64, true);

    if (this.shippingOptions == null) {
      encoder0.encodeNullPointer(72, true);
    } else {
      org.chromium.mojo.bindings.Encoder encoder1 =
          encoder0.encodePointerArray(
              this.shippingOptions.length,
              72,
              org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
      for (int i0 = 0; i0 < this.shippingOptions.length; ++i0) {

        encoder1.encode(
            this.shippingOptions[i0],
            org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0,
            false);
      }
    }

    encoder0.encode(this.paymentHandlerHost, 80, true, PaymentHandlerHost.MANAGER);
  }
}
