package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackgroundFetchRegistrationData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String developerId;
  public long downloadTotal;
  public long downloaded;
  public int failureReason;
  public int result;
  public long uploadTotal;
  public long uploaded;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackgroundFetchRegistrationData(int version) {
    super(56, version);
    this.result = 0;
    this.failureReason = 0;
  }

  public BackgroundFetchRegistrationData() {
    this(0);
  }

  public static BackgroundFetchRegistrationData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackgroundFetchRegistrationData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackgroundFetchRegistrationData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackgroundFetchRegistrationData result =
          new BackgroundFetchRegistrationData(elementsOrVersion);
      result.developerId = decoder0.readString(8, false);
      result.uploadTotal = decoder0.readLong(16);
      result.uploaded = decoder0.readLong(24);
      result.downloadTotal = decoder0.readLong(32);
      result.downloaded = decoder0.readLong(40);
      int readInt = decoder0.readInt(48);
      result.result = readInt;
      BackgroundFetchResult.validate(readInt);
      result.result = BackgroundFetchResult.toKnownValue(result.result);
      int readInt2 = decoder0.readInt(52);
      result.failureReason = readInt2;
      BackgroundFetchFailureReason.validate(readInt2);
      result.failureReason = BackgroundFetchFailureReason.toKnownValue(result.failureReason);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.developerId, 8, false);
    encoder0.encode(this.uploadTotal, 16);
    encoder0.encode(this.uploaded, 24);
    encoder0.encode(this.downloadTotal, 32);
    encoder0.encode(this.downloaded, 40);
    encoder0.encode(this.result, 48);
    encoder0.encode(this.failureReason, 52);
  }
}
