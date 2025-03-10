package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class ManifestShareTargetParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public ManifestFileFilter[] files;
  public String16 text;
  public String16 title;
  public String16 url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ManifestShareTargetParams(int version) {
    super(40, version);
  }

  public ManifestShareTargetParams() {
    this(0);
  }

  public static ManifestShareTargetParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ManifestShareTargetParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ManifestShareTargetParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ManifestShareTargetParams result = new ManifestShareTargetParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.title = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.text = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.url = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      if (decoder14 == null) {
        result.files = null;
      } else {
        DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
        result.files = new ManifestFileFilter[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
          result.files[i1] = ManifestFileFilter.decode(decoder2);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.title, 8, true);
    encoder0.encode((Struct) this.text, 16, true);
    encoder0.encode((Struct) this.url, 24, true);
    ManifestFileFilter[] manifestFileFilterArr = this.files;
    if (manifestFileFilterArr == null) {
      encoder0.encodeNullPointer(32, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(manifestFileFilterArr.length, 32, -1);
    int i0 = 0;
    while (true) {
      ManifestFileFilter[] manifestFileFilterArr2 = this.files;
      if (i0 < manifestFileFilterArr2.length) {
        encoder1.encode((Struct) manifestFileFilterArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
