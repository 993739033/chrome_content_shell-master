package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CdmKeyInformation extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] keyId;
  public int status;
  public int systemCode;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CdmKeyInformation(int version) {
    super(24, version);
  }

  public CdmKeyInformation() {
    this(0);
  }

  public static CdmKeyInformation deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CdmKeyInformation deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CdmKeyInformation decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CdmKeyInformation result = new CdmKeyInformation(elementsOrVersion);
      result.keyId = decoder0.readBytes(8, 0, -1);
      int readInt = decoder0.readInt(16);
      result.status = readInt;
      CdmKeyStatus.validate(readInt);
      result.status = CdmKeyStatus.toKnownValue(result.status);
      result.systemCode = decoder0.readInt(20);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.keyId, 8, 0, -1);
    encoder0.encode(this.status, 16);
    encoder0.encode(this.systemCode, 20);
  }
}
