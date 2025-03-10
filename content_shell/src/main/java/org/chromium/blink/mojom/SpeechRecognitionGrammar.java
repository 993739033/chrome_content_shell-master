package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class SpeechRecognitionGrammar extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Url url;
  public double weight;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SpeechRecognitionGrammar(int version) {
    super(24, version);
  }

  public SpeechRecognitionGrammar() {
    this(0);
  }

  public static SpeechRecognitionGrammar deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SpeechRecognitionGrammar deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SpeechRecognitionGrammar decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SpeechRecognitionGrammar result = new SpeechRecognitionGrammar(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      result.weight = decoder0.readDouble(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode(this.weight, 16);
  }
}
