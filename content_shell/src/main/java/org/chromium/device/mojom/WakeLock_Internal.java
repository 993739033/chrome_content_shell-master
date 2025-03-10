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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WakeLock_Internal {
  private static final int ADD_CLIENT_ORDINAL = 2;
  private static final int CANCEL_WAKE_LOCK_ORDINAL = 1;
  private static final int CHANGE_TYPE_ORDINAL = 3;
  private static final int HAS_WAKE_LOCK_FOR_TESTS_ORDINAL = 4;
  public static final Interface.Manager<WakeLock, WakeLock.Proxy> MANAGER =
      new Interface.Manager<WakeLock, WakeLock.Proxy>() {
        @Override
        public String getName() {
          return "device.mojom.WakeLock";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public WakeLock.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, WakeLock impl) {
          return new Stub(core, impl);
        }

        @Override
        public WakeLock[] buildArray(int size) {
          return new WakeLock[size];
        }
      };
  private static final int REQUEST_WAKE_LOCK_ORDINAL = 0;

  WakeLock_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements WakeLock.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void requestWakeLock() {
      WakeLockRequestWakeLockParams _message = new WakeLockRequestWakeLockParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }

    @Override
    public void cancelWakeLock() {
      WakeLockCancelWakeLockParams _message = new WakeLockCancelWakeLockParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void addClient(InterfaceRequest<WakeLock> wakeLock) {
      WakeLockAddClientParams _message = new WakeLockAddClientParams();
      _message.wakeLock = wakeLock;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void changeType(int type, ChangeType_Response callback) {
      WakeLockChangeTypeParams _message = new WakeLockChangeTypeParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new WakeLockChangeTypeResponseParamsForwardToCallback(callback));
    }

    @Override
    public void hasWakeLockForTests(HasWakeLockForTests_Response callback) {
      WakeLockHasWakeLockForTestsParams _message = new WakeLockHasWakeLockForTestsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new WakeLockHasWakeLockForTestsResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<WakeLock> {
    Stub(Core core, WakeLock impl) {
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
                WakeLock_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            WakeLockRequestWakeLockParams.deserialize(messageWithHeader.getPayload());
            getImpl().requestWakeLock();
            return true;
          case 1:
            WakeLockCancelWakeLockParams.deserialize(messageWithHeader.getPayload());
            getImpl().cancelWakeLock();
            return true;
          case 2:
            WakeLockAddClientParams data =
                WakeLockAddClientParams.deserialize(messageWithHeader.getPayload());
            getImpl().addClient(data.wakeLock);
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
                getCore(), WakeLock_Internal.MANAGER, messageWithHeader, receiver);
          case 3:
            WakeLockChangeTypeParams data =
                WakeLockChangeTypeParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .changeType(
                    data.type,
                    new WakeLockChangeTypeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            WakeLockHasWakeLockForTestsParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .hasWakeLockForTests(
                    new WakeLockHasWakeLockForTestsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class WakeLockRequestWakeLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockRequestWakeLockParams(int version) {
      super(8, version);
    }

    public WakeLockRequestWakeLockParams() {
      this(0);
    }

    public static WakeLockRequestWakeLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockRequestWakeLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockRequestWakeLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockRequestWakeLockParams result = new WakeLockRequestWakeLockParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WakeLockCancelWakeLockParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockCancelWakeLockParams(int version) {
      super(8, version);
    }

    public WakeLockCancelWakeLockParams() {
      this(0);
    }

    public static WakeLockCancelWakeLockParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockCancelWakeLockParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockCancelWakeLockParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockCancelWakeLockParams result = new WakeLockCancelWakeLockParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WakeLockAddClientParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<WakeLock> wakeLock;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockAddClientParams(int version) {
      super(16, version);
    }

    public WakeLockAddClientParams() {
      this(0);
    }

    public static WakeLockAddClientParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockAddClientParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockAddClientParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockAddClientParams result = new WakeLockAddClientParams(elementsOrVersion);
        result.wakeLock = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.wakeLock, 8, false);
    }
  }

  static final class WakeLockChangeTypeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockChangeTypeParams(int version) {
      super(16, version);
    }

    public WakeLockChangeTypeParams() {
      this(0);
    }

    public static WakeLockChangeTypeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockChangeTypeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockChangeTypeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockChangeTypeParams result = new WakeLockChangeTypeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        WakeLockType.validate(readInt);
        result.type = WakeLockType.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class WakeLockChangeTypeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockChangeTypeResponseParams(int version) {
      super(16, version);
    }

    public WakeLockChangeTypeResponseParams() {
      this(0);
    }

    public static WakeLockChangeTypeResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockChangeTypeResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockChangeTypeResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockChangeTypeResponseParams result =
            new WakeLockChangeTypeResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WakeLockChangeTypeResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final WakeLock.ChangeType_Response mCallback;

    WakeLockChangeTypeResponseParamsForwardToCallback(WakeLock.ChangeType_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        WakeLockChangeTypeResponseParams response =
            WakeLockChangeTypeResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WakeLockChangeTypeResponseParamsProxyToResponder
      implements WakeLock.ChangeType_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WakeLockChangeTypeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WakeLockChangeTypeResponseParams _response = new WakeLockChangeTypeResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class WakeLockHasWakeLockForTestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockHasWakeLockForTestsParams(int version) {
      super(8, version);
    }

    public WakeLockHasWakeLockForTestsParams() {
      this(0);
    }

    public static WakeLockHasWakeLockForTestsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockHasWakeLockForTestsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockHasWakeLockForTestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockHasWakeLockForTestsParams result =
            new WakeLockHasWakeLockForTestsParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class WakeLockHasWakeLockForTestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private WakeLockHasWakeLockForTestsResponseParams(int version) {
      super(16, version);
    }

    public WakeLockHasWakeLockForTestsResponseParams() {
      this(0);
    }

    public static WakeLockHasWakeLockForTestsResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static WakeLockHasWakeLockForTestsResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static WakeLockHasWakeLockForTestsResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        WakeLockHasWakeLockForTestsResponseParams result =
            new WakeLockHasWakeLockForTestsResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class WakeLockHasWakeLockForTestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final WakeLock.HasWakeLockForTests_Response mCallback;

    WakeLockHasWakeLockForTestsResponseParamsForwardToCallback(
        WakeLock.HasWakeLockForTests_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        WakeLockHasWakeLockForTestsResponseParams response =
            WakeLockHasWakeLockForTestsResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class WakeLockHasWakeLockForTestsResponseParamsProxyToResponder
      implements WakeLock.HasWakeLockForTests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    WakeLockHasWakeLockForTestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      WakeLockHasWakeLockForTestsResponseParams _response =
          new WakeLockHasWakeLockForTestsResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
