package com.example.ricindigus.pruebaretrofitquiebre;

import java.util.List;

public class RedObject {
    private Message message;
    private NetworkTypeList[] networkTypeList;

    public Message getMessage() { return message; }
    public void setMessage(Message value) { this.message = value; }

    public NetworkTypeList[] getNetworkTypeList() {
        return networkTypeList;
    }

    public void setNetworkTypeList(NetworkTypeList[] networkTypeList) {
        this.networkTypeList = networkTypeList;
    }
}
