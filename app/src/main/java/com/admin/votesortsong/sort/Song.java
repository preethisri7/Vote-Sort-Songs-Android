package com.admin.votesortsong.sort;

class Song {

    private String vote;
    private String title;
    private int image;

    public Song(String vote, String title, int image) {
        this.vote = vote;
        this.title = title;
        this.image = image;
    }

    public String getVote() {
        return vote;
    }

    public void setRank(String vote) {
        this.vote = vote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
      return image;
    }

    public void setImage(int image) {
      this.image = image;
    }

}
