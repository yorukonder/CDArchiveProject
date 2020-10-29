package sockets;

public interface MessageListener {
    void message(String msg, MessageSender sender);

}
