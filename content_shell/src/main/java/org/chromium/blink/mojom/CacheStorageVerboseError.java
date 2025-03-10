package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CacheStorageVerboseError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String message;
  public int value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CacheStorageVerboseError(int version) {
    super(24, version);
  }

  public CacheStorageVerboseError() {
    this(0);
  }

  public static CacheStorageVerboseError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CacheStorageVerboseError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CacheStorageVerboseError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CacheStorageVerboseError result = new CacheStorageVerboseError(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.value = readInt;
      CacheStorageError.validate(readInt);
      result.value = CacheStorageError.toKnownValue(result.value);
      result.message = decoder0.readString(16, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.value, 8);
    encoder0.encode(this.message, 16, true);
  }
}
