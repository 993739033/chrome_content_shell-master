package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ReceivedSnapshotListener_Internal {
  private static final int DID_RECEIVE_SNAPSHOT_FILE_ORDINAL = 0;
  public static final Interface.Manager<ReceivedSnapshotListener, ReceivedSnapshotListener.Proxy>
      MANAGER =
          new Interface.Manager<ReceivedSnapshotListener, ReceivedSnapshotListener.Proxy>() {
            @Override
            public String getName() {
              return "blink.mojom.ReceivedSnapshotListener";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public ReceivedSnapshotListener.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, ReceivedSnapshotListener impl) {
              return new Stub(core, impl);
            }

            @Override
            public ReceivedSnapshotListener[] buildArray(int size) {
              return new ReceivedSnapshotListener[size];
            }
          };

  ReceivedSnapshotListener_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ReceivedSnapshotListener.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void didReceiveSnapshotFile() {
      ReceivedSnapshotListenerDidReceiveSnapshotFileParams _message =
          new ReceivedSnapshotListenerDidReceiveSnapshotFileParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ReceivedSnapshotListener> {
    Stub(Core core, ReceivedSnapshotListener impl) {
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
                ReceivedSnapshotListener_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ReceivedSnapshotListenerDidReceiveSnapshotFileParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didReceiveSnapshotFile();
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
                getCore(), ReceivedSnapshotListener_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ReceivedSnapshotListenerDidReceiveSnapshotFileParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ReceivedSnapshotListenerDidReceiveSnapshotFileParams(int version) {
      super(8, version);
    }

    public ReceivedSnapshotListenerDidReceiveSnapshotFileParams() {
      this(0);
    }

    public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ReceivedSnapshotListenerDidReceiveSnapshotFileParams result =
            new ReceivedSnapshotListenerDidReceiveSnapshotFileParams(elementsOrVersion);
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
}
