package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Vp8Metadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean layerSync;
  public boolean nonReference;
  public byte temporalIdx;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Vp8Metadata(int version) {
    super(16, version);
  }

  public Vp8Metadata() {
    this(0);
  }

  public static Vp8Metadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Vp8Metadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Vp8Metadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Vp8Metadata result = new Vp8Metadata(elementsOrVersion);
      result.nonReference = decoder0.readBoolean(8, 0);
      result.layerSync = decoder0.readBoolean(8, 1);
      result.temporalIdx = decoder0.readByte(9);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.nonReference, 8, 0);
    encoder0.encode(this.layerSync, 8, 1);
    encoder0.encode(this.temporalIdx, 9);
  }
}
