package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public final class FileSystemFileInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public long length;
  public Time modificationTime;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FileSystemFileInfo(int version) {
    super(32, version);
    this.length = 0L;
  }

  public FileSystemFileInfo() {
    this(0);
  }

  public static FileSystemFileInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FileSystemFileInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FileSystemFileInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FileSystemFileInfo result = new FileSystemFileInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.modificationTime = Time.decode(decoder12);
      result.length = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.modificationTime, 16, false);
    encoder0.encode(this.length, 24);
  }
}
