package com.example.hvn15.shownotifier;

import com.google.gson.annotations.SerializedName;

class Country{
    @SerializedName("iso_3166_1")
    private String iso_3166_1;

    @SerializedName("english_name")
    private String english_name;

    public Country(String iso_3166_1, String english_name) {
        this.iso_3166_1 = iso_3166_1;
        this.english_name = english_name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", english_name='" + english_name + '\'' +
                '}';
    }
}