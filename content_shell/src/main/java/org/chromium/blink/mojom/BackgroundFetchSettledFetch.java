package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackgroundFetchSettledFetch extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public FetchApiRequest request;
  public FetchApiResponse response;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackgroundFetchSettledFetch(int version) {
    super(24, version);
  }

  public BackgroundFetchSettledFetch() {
    this(0);
  }

  public static BackgroundFetchSettledFetch deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackgroundFetchSettledFetch deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackgroundFetchSettledFetch decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackgroundFetchSettledFetch result = new BackgroundFetchSettledFetch(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.request = FetchApiRequest.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.response = FetchApiResponse.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.request, 8, false);
    encoder0.encode((Struct) this.response, 16, true);
  }
}
