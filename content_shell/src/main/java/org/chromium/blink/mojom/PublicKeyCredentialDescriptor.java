package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PublicKeyCredentialDescriptor extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;

  public byte[] f450id;
  public int[] transports;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PublicKeyCredentialDescriptor(int version) {
    super(32, version);
  }

  public PublicKeyCredentialDescriptor() {
    this(0);
  }

  public static PublicKeyCredentialDescriptor deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PublicKeyCredentialDescriptor deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PublicKeyCredentialDescriptor decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PublicKeyCredentialDescriptor result = new PublicKeyCredentialDescriptor(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      PublicKeyCredentialType.validate(readInt);
      result.type = PublicKeyCredentialType.toKnownValue(result.type);
      result.f450id = decoder0.readBytes(16, 0, -1);
      result.transports = decoder0.readInts(24, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.transports;
        if (i1 < iArr.length) {
          AuthenticatorTransport.validate(iArr[i1]);
          i1++;
        } else {
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.f450id, 16, 0, -1);
    encoder0.encode(this.transports, 24, 0, -1);
  }
}
