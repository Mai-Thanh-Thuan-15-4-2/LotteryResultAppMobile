package com.example.kqxs;

public class radioModel {
    private String nameRadio;
    private String titleRadio;
    private String linkRss;
    public radioModel(String nameRadio, String titleRadio, String rss) {
        this.nameRadio = nameRadio;
        this.titleRadio = titleRadio;
        this.linkRss = rss;
    }

    public String getNameRadio() {
        return nameRadio;
    }

    public void setNameRadio(String nameRadio) {
        this.nameRadio = nameRadio;
    }

    public String getTitleRadio() {
        return titleRadio;
    }

    public void setTitleRadio(String titleRadio) {
        this.titleRadio = titleRadio;
    }

    public String getLinkRss() {
        return linkRss;
    }

    public void setLinkRss(String linkRss) {
        this.linkRss = linkRss;
    }

    @Override
    public String toString() {
        return "radioModel{" +
                "nameRadio='" + nameRadio + '\'' +
                ", titleRadio='" + titleRadio + '\'' +
                ", linkRss='" + linkRss + '\'' +
                '}';
    }
}
