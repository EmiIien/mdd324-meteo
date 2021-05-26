package com.ipiecoles;

public class Weather {
    private String coucher;
    private Integer humidite;
    private Integer icon;
    private String lever;
    private Double temp;
    private String temps;

    @Override
    public String toString() {
        return "Weather{" +
                "coucher='" + coucher + '\'' +
                ", humidite=" + humidite +
                ", icon=" + icon +
                ", lever='" + lever + '\'' +
                ", temp=" + temp +
                ", temps='" + temps + '\'' +
                '}';
    }

    public Weather(String coucher, Integer humidite, Integer icon, String lever, Double temp, String temps) {
        this.coucher = coucher;
        this.humidite = humidite;
        this.icon = icon;
        this.lever = lever;
        this.temp = temp;
        this.temps = temps;
    }

    public String getCoucher() {
        return coucher;
    }

    public void setCoucher(String coucher) {
        this.coucher = coucher;
    }

    public Integer getHumidite() {
        return humidite;
    }

    public void setHumidite(Integer humidite) {
        this.humidite = humidite;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }
}
