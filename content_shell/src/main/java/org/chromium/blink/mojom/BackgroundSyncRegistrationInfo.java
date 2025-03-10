package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackgroundSyncRegistrationInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public long serviceWorkerRegistrationId;
  public int syncType;
  public String tag;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackgroundSyncRegistrationInfo(int version) {
    super(32, version);
    this.serviceWorkerRegistrationId = -1L;
  }

  public BackgroundSyncRegistrationInfo() {
    this(0);
  }

  public static BackgroundSyncRegistrationInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackgroundSyncRegistrationInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackgroundSyncRegistrationInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackgroundSyncRegistrationInfo result = new BackgroundSyncRegistrationInfo(elementsOrVersion);
      result.serviceWorkerRegistrationId = decoder0.readLong(8);
      result.tag = decoder0.readString(16, false);
      int readInt = decoder0.readInt(24);
      result.syncType = readInt;
      BackgroundSyncType.validate(readInt);
      result.syncType = BackgroundSyncType.toKnownValue(result.syncType);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.serviceWorkerRegistrationId, 8);
    encoder0.encode(this.tag, 16, false);
    encoder0.encode(this.syncType, 24);
  }
}
