package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class UsbDeviceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public byte activeConfiguration;
  public int busNumber;
  public byte classCode;
  public UsbConfigurationInfo[] configurations;
  public byte deviceVersionMajor;
  public byte deviceVersionMinor;
  public byte deviceVersionSubminor;
  public String guid;
  public String16 manufacturerName;
  public int portNumber;
  public short productId;
  public String16 productName;
  public byte protocolCode;
  public String16 serialNumber;
  public byte subclassCode;
  public byte usbVersionMajor;
  public byte usbVersionMinor;
  public byte usbVersionSubminor;
  public short vendorId;
  public Url webusbLandingPage;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsbDeviceInfo(int version) {
    super(80, version);
  }

  public UsbDeviceInfo() {
    this(0);
  }

  public static UsbDeviceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsbDeviceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsbDeviceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsbDeviceInfo result = new UsbDeviceInfo(elementsOrVersion);
      result.guid = decoder0.readString(8, false);
      result.usbVersionMajor = decoder0.readByte(16);
      result.usbVersionMinor = decoder0.readByte(17);
      result.usbVersionSubminor = decoder0.readByte(18);
      result.classCode = decoder0.readByte(19);
      result.subclassCode = decoder0.readByte(20);
      result.protocolCode = decoder0.readByte(21);
      result.vendorId = decoder0.readShort(22);
      result.busNumber = decoder0.readInt(24);
      result.portNumber = decoder0.readInt(28);
      result.productId = decoder0.readShort(32);
      result.deviceVersionMajor = decoder0.readByte(34);
      result.deviceVersionMinor = decoder0.readByte(35);
      result.deviceVersionSubminor = decoder0.readByte(36);
      result.activeConfiguration = decoder0.readByte(37);
      Decoder decoder1 = decoder0.readPointer(40, true);
      result.manufacturerName = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(48, true);
      result.productName = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(56, true);
      result.serialNumber = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(64, true);
      result.webusbLandingPage = Url.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(72, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.configurations = new UsbConfigurationInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.configurations[i1] = UsbConfigurationInfo.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.guid, 8, false);
    encoder0.encode(this.usbVersionMajor, 16);
    encoder0.encode(this.usbVersionMinor, 17);
    encoder0.encode(this.usbVersionSubminor, 18);
    encoder0.encode(this.classCode, 19);
    encoder0.encode(this.subclassCode, 20);
    encoder0.encode(this.protocolCode, 21);
    encoder0.encode(this.vendorId, 22);
    encoder0.encode(this.busNumber, 24);
    encoder0.encode(this.portNumber, 28);
    encoder0.encode(this.productId, 32);
    encoder0.encode(this.deviceVersionMajor, 34);
    encoder0.encode(this.deviceVersionMinor, 35);
    encoder0.encode(this.deviceVersionSubminor, 36);
    encoder0.encode(this.activeConfiguration, 37);
    encoder0.encode((Struct) this.manufacturerName, 40, true);
    encoder0.encode((Struct) this.productName, 48, true);
    encoder0.encode((Struct) this.serialNumber, 56, true);
    encoder0.encode((Struct) this.webusbLandingPage, 64, true);
    UsbConfigurationInfo[] usbConfigurationInfoArr = this.configurations;
    if (usbConfigurationInfoArr == null) {
      encoder0.encodeNullPointer(72, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(usbConfigurationInfoArr.length, 72, -1);
    int i0 = 0;
    while (true) {
      UsbConfigurationInfo[] usbConfigurationInfoArr2 = this.configurations;
      if (i0 < usbConfigurationInfoArr2.length) {
        encoder1.encode((Struct) usbConfigurationInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
