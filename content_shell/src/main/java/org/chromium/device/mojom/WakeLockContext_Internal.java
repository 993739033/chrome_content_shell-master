package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WakeLockContext_Internal {
  private static final int GET_WAKE_LOCK_ORDINAL = 0;
  public static final Interface.Manager<WakeLockContext, WakeLockContext.Proxy> MANAGER =
      new Interface.Manager<WakeLockContext, WakeLockContext.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.WakeLockContext";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WakeLockContext.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WakeLockContext impl) {
          return new Stub(core, impl);
        }

        @Override
        public WakeLockContext[] buildArray(int size) {
          return new WakeLockContext[size];
        }
      };

  WakeLockContext_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WakeLockContext.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getWakeLock(
        int type, int reason, String description, InterfaceRequest<WakeLock> wakeLock) {
      WakeLockContextGetWakeLockParams _message = new WakeLockContextGetWakeLockParams();
      _message.type = type;
      _message.reason = reason;
      _message.description = description;
      _message.wakeLock = wakeLock;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<WakeLockContext> {
    Stub(Core core, WakeLockContext impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                WakeLockContext_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WakeLockContextGetWakeLockParams data =
                WakeLockContextGetWakeLockParams.deserialize(messageWithHeader.getPayload());
            getImpl().getWakeLock(data.type, data.reason, data.description, data.wakeLock);
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), WakeLockContext_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WakeLockContextGetWakeLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String description;
    public int reason;
    public int type;
    public InterfaceRequest<WakeLock> wakeLock;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockContextGetWakeLockParams(int version) {
      super(32, version);
    }

    public WakeLockContextGetWakeLockParams() {
      this(0);
    }

    public static WakeLockContextGetWakeLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockContextGetWakeLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockContextGetWakeLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockContextGetWakeLockParams result =
            new WakeLockContextGetWakeLockParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        int readInt2 = decoder0.readInt(12);
        result.reason = readInt2;
        WakeLockReason.validate(readInt2);
        result.reason = WakeLockReason.toKnownValue(result.reason);
        result.description = decoder0.readString(16, false);
        result.wakeLock = decoder0.readInterfaceRequest(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
      encoder0.encode(this.reason, 12);
      encoder0.encode(this.description, 16, false);
      encoder0.encode((InterfaceRequest) this.wakeLock, 24, false);
    }
  }
}
