package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SyncRegistrationOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public long minInterval;
  public String tag;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SyncRegistrationOptions(int version) {
    super(24, version);
    this.tag = "";
    this.minInterval = -1L;
  }

  public SyncRegistrationOptions() {
    this(0);
  }

  public static SyncRegistrationOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SyncRegistrationOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SyncRegistrationOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SyncRegistrationOptions result = new SyncRegistrationOptions(elementsOrVersion);
      result.tag = decoder0.readString(8, false);
      result.minInterval = decoder0.readLong(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.tag, 8, false);
    encoder0.encode(this.minInterval, 16);
  }
}
