package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class DecoderBuffer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeDelta backDiscard;
  public int dataSize;
  public DecryptConfig decryptConfig;
  public TimeDelta duration;
  public TimeDelta frontDiscard;
  public boolean isEndOfStream;
  public boolean isKeyFrame;
  public DecoderBufferSideData sideData;
  public TimeDelta timestamp;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DecoderBuffer(int version) {
    super(64, version);
  }

  public DecoderBuffer() {
    this(0);
  }

  public static DecoderBuffer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DecoderBuffer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DecoderBuffer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DecoderBuffer result = new DecoderBuffer(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.timestamp = TimeDelta.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.duration = TimeDelta.decode(decoder12);
      result.isEndOfStream = decoder0.readBoolean(24, 0);
      result.isKeyFrame = decoder0.readBoolean(24, 1);
      result.dataSize = decoder0.readInt(28);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.decryptConfig = DecryptConfig.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.frontDiscard = TimeDelta.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.backDiscard = TimeDelta.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(56, true);
      result.sideData = DecoderBufferSideData.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.timestamp, 8, false);
    encoder0.encode((Struct) this.duration, 16, false);
    encoder0.encode(this.isEndOfStream, 24, 0);
    encoder0.encode(this.isKeyFrame, 24, 1);
    encoder0.encode(this.dataSize, 28);
    encoder0.encode((Struct) this.decryptConfig, 32, true);
    encoder0.encode((Struct) this.frontDiscard, 40, false);
    encoder0.encode((Struct) this.backDiscard, 48, false);
    encoder0.encode((Struct) this.sideData, 56, true);
  }
}
