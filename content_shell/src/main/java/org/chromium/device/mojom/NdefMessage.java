package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NdefMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public NdefRecord[] data;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NdefMessage(int version) {
    super(16, version);
  }

  public NdefMessage() {
    this(0);
  }

  public static NdefMessage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NdefMessage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NdefMessage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NdefMessage result = new NdefMessage(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.data = new NdefRecord[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.data[i1] = NdefRecord.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    NdefRecord[] ndefRecordArr = this.data;
    if (ndefRecordArr == null) {
      encoder0.encodeNullPointer(8, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(ndefRecordArr.length, 8, -1);
    int i0 = 0;
    while (true) {
      NdefRecord[] ndefRecordArr2 = this.data;
      if (i0 < ndefRecordArr2.length) {
        encoder1.encode((Struct) ndefRecordArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
