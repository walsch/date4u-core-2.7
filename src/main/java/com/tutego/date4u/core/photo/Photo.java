package com.tutego.date4u.core.photo;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class Photo {

  public Long id;
  @Min( 1 ) public long profile;
  @NotNull @Pattern( regexp = "\\w{1,200}" ) public String name;
  public boolean isProfilePhoto;
  @NotNull @Past public LocalDateTime created;

  public Photo() {
  }

  public Photo( Long id, long profile, String name, boolean isProfilePhoto, LocalDateTime created ) {
    this.id = id;
    this.profile = profile;
    this.name = name;
    this.isProfilePhoto = isProfilePhoto;
    this.created = created;
  }

  @Override public String toString() {
    return "Photo{" +
           "id=" + id +
           ", profile=" + profile +
           ", name='" + name + '\'' +
           ", isProfilePhoto=" + isProfilePhoto +
           ", created=" + created +
           '}';
  }
}