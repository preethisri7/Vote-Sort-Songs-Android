package com.admin.votesortsong.sort;

import java.io.Serializable;

/**
 * Created by Admin on 12/28/2016.
 */

public class MusicBean implements Serializable {


  private long musicID;
  private String musicTitle;
  private String artist;
  private boolean inPlayist;
  private int votes;
 // private int image;

  public MusicBean(long musicID,String musicTitle,String artist,boolean inPlayist,int votes) {
    this.musicID = musicID;
    this.musicTitle=musicTitle;
    this.artist=artist;
    this.inPlayist=inPlayist;
    this.votes=votes;
   // this.image = image;
  }

  public long getMusicID() {
    return musicID;
  }

  public void setMusicID(long musicID) {
    this.musicID = musicID;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getMusicTitle() {
    return musicTitle;
  }

  public void setMusicTitle(String musicTitle) {
    this.musicTitle = musicTitle;
  }


  public boolean isInPlayist() {
    return inPlayist;
  }

  public void setInPlayist(boolean inPlayist) {
    this.inPlayist = inPlayist;
  }

  public int getVotes() {
    return votes;
  }

  public void setVotes(int votes) {
    this.votes = votes;
  }
 /* public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image =image;
  } */
}
