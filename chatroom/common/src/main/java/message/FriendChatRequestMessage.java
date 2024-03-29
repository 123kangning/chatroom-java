package message;

public class FriendChatRequestMessage extends Message {
    private int userID;
    private int FriendId;
    private String msg_type;//S=文本消息、F=文件
    //talker默认为F=friend
    private String message;
    private String prefix;
    private String talker_type;//G=消息来自群组,F=消息来自个人
    private byte[] file;
    private int fileSize;
    private int start;
    private int onceSize;
    private String path;
    private String fileName;
    private int count = 1;//登录时用其统计未读信息条数
    private int Group = 0;

    public FriendChatRequestMessage() {
    }

    public FriendChatRequestMessage(int userID, int FriendId, String message, String msg_type) {
        this.userID = userID;
        this.FriendId = FriendId;
        this.message = message;
        this.msg_type = msg_type;
    }

    public FriendChatRequestMessage(int userID, int FriendId, byte[] file, String msg_type) {
        this.userID = userID;
        this.FriendId = FriendId;
        this.file = file;
        this.msg_type = msg_type;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setOnceSize(int onceSize) {
        this.onceSize = onceSize;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTalker_type(String talker_type) {
        this.talker_type = talker_type;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public void setGroup(int group) {
        Group = group;
    }

    public String getFileName() {
        return fileName;
    }

    public int getOnceSize() {
        return onceSize;
    }

    public int getStart() {
        return start;
    }

    public String getPath() {
        return path;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getTalker_type() {
        return talker_type;
    }

    public int getGroup() {
        return Group;
    }


    public String getPrefix() {
        return prefix;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public byte[] getFile() {
        return file;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return this.message;
    }

    public int getFriendId() {
        return this.FriendId;
    }

    public int getUserID() {
        return this.userID;
    }

    /*    @Override
        public int getMessageType() {
            return FriendChatRequestMessage;
        }*/
    public String toString() {
        return "userID = " + userID + ", FriendId = " + FriendId + " message = " + message;
    }
}
