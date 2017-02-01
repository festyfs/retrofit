/**
 * Created by Festy on 2/1/2017.
 */
package com.example.festy.retrofitjson;
//tempat menampung data yang didapat

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("npsn")
    @Expose
    private String npsn;
    @SerializedName("institution_name")
    @Expose
    private String institutionName;

    public Profile( String npsn, String institutionName) {
        this.npsn = npsn;
        this.institutionName = institutionName;
    }

    public Profile(){

    }

    public String getNpsn() {
        return npsn;
    }

    public void setNpsn(String npsn) {
        this.npsn = npsn;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}