package com.bagusyosi.psdkubemvote.model;

import com.google.gson.annotations.SerializedName;

public class ModelCapres {

    @SerializedName("NOMER_URUT") private int nomerUrutCalon;
    @SerializedName("NAMA_CAPRES") private String namaCapres;
    @SerializedName("PEKERJAAN_CAPRES") private String pekerjaanCapres;
    @SerializedName("PROFIL_CAPRES") private String profilCapres;
    @SerializedName("JURUSAN_CAPRES") private String jurusanCapres;
    @SerializedName("NAMA_CAWAPRES") private String namaCawapres;
    @SerializedName("PEKERJAAN_CAWAPRES") private String pekerjaanCawapres;
    @SerializedName("PROFIL_CAWAPRES") private String profilCawapres;
    @SerializedName("JUR_CAWAPRES") private String jurCawapres;
    @SerializedName("SLOGAN") private String sloganCalon;
    @SerializedName("FOTOCALON") private String fotoCalon;

    public int getNomerUrutCalon() {
        return nomerUrutCalon;
    }

    public String getNamaCapres() {
        return namaCapres;
    }

    public String getPekerjaanCapres() {
        return pekerjaanCapres;
    }

    public String getProfilCapres() {
        return profilCapres;
    }

    public String getJurusanCapres() {
        return jurusanCapres;
    }

    public String getNamaCawapres() {
        return namaCawapres;
    }

    public String getPekerjaanCawapres() {
        return pekerjaanCawapres;
    }

    public String getProfilCawapres() {
        return profilCawapres;
    }

    public String getJurCawapres() {
        return jurCawapres;
    }

    public String getSloganCalon() {
        return sloganCalon;
    }

    public String getFotoCalon() {
        return fotoCalon;
    }
}
