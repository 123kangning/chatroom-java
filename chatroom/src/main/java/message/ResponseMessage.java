package message;

public class ResponseMessage extends Message{
    private boolean success;
    private String reason;
    int MessageType=ResponseMessage;
    public ResponseMessage(){}
    public ResponseMessage(boolean success,String reason){
        this.success=success;
        this.reason=reason;
    }
    public void setMessageType(int MessageType){
        this.MessageType=MessageType;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public String getReason(){
        return this.reason;
    }
    public int getMessageType() {
        return this.MessageType;
    }
    public String toString(){
        return "success = "+success+", reason = "+reason;
    }
}