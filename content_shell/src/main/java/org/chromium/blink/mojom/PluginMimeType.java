package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class PluginMimeType extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 description;
  public String[] fileExtensions;
  public String mimeType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PluginMimeType(int version) {
    super(32, version);
  }

  public PluginMimeType() {
    this(0);
  }

  public static PluginMimeType deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PluginMimeType deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PluginMimeType decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PluginMimeType result = new PluginMimeType(elementsOrVersion);
      result.mimeType = decoder0.readString(8, false);
      result.description = String16.decode(decoder0.readPointer(16, false));
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.fileExtensions = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.fileExtensions[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.mimeType, 8, false);
    encoder0.encode((Struct) this.description, 16, false);
    String[] strArr = this.fileExtensions;
    if (strArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.fileExtensions;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
