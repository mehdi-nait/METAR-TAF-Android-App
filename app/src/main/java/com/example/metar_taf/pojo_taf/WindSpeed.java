
package com.example.metar_taf.pojo_taf;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WindSpeed {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("spoken")
    @Expose
    private String spoken;

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getSpoken() {
        return spoken;
    }

    public void setSpoken(String spoken) {
        this.spoken = spoken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WindSpeed.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("repr");
        sb.append('=');
        sb.append(((this.repr == null)?"<null>":this.repr));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("spoken");
        sb.append('=');
        sb.append(((this.spoken == null)?"<null>":this.spoken));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
