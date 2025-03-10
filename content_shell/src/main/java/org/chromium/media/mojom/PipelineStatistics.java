package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PipelineStatistics extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public long audioBytesDecoded;
  public long audioMemoryUsage;
  public long videoBytesDecoded;
  public int videoFramesDecoded;
  public int videoFramesDropped;
  public long videoMemoryUsage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PipelineStatistics(int version) {
    super(48, version);
  }

  public PipelineStatistics() {
    this(0);
  }

  public static PipelineStatistics deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PipelineStatistics deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PipelineStatistics decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PipelineStatistics result = new PipelineStatistics(elementsOrVersion);
      result.audioBytesDecoded = decoder0.readLong(8);
      result.videoBytesDecoded = decoder0.readLong(16);
      result.videoFramesDecoded = decoder0.readInt(24);
      result.videoFramesDropped = decoder0.readInt(28);
      result.audioMemoryUsage = decoder0.readLong(32);
      result.videoMemoryUsage = decoder0.readLong(40);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.audioBytesDecoded, 8);
    encoder0.encode(this.videoBytesDecoded, 16);
    encoder0.encode(this.videoFramesDecoded, 24);
    encoder0.encode(this.videoFramesDropped, 28);
    encoder0.encode(this.audioMemoryUsage, 32);
    encoder0.encode(this.videoMemoryUsage, 40);
  }
}
