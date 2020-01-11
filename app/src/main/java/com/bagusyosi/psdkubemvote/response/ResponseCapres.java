package com.bagusyosi.psdkubemvote.response;

import com.bagusyosi.psdkubemvote.model.ModelCapres;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCapres {

    @SerializedName("capres")
    private List<ModelCapres> allCapres;

    public List<ModelCapres> getAllCapresOnVoting() {
        return allCapres;
    }

}
