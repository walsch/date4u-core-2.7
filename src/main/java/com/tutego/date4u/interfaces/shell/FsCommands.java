package com.tutego.date4u.interfaces.shell;

import com.tutego.date4u.core.FileSystem;
import com.tutego.date4u.core.configuration.Date4uProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

@ShellComponent
public class FsCommands {

  private final Logger log = LoggerFactory.getLogger( getClass() );

  private final Environment environment;
  private final FileSystem fs;

  //  @Value( "${date4u.filesystem.minimum-free-disk-space:1000000}" )
  //  private long minimumFreeDiskSpace;

  private final Date4uProperties date4uProperties;

  public FsCommands( FileSystem fs, Environment environment,
                     Date4uProperties date4uProperties ) {
    this.environment = environment;
    this.fs = fs;
    this.date4uProperties = date4uProperties;

//    long freediskspace = date4uProperties.getFilesystem().getMinimumFreeDiskSpace();
//    if ( fs.getFreeDiskSpace() < freediskspace ) {
//      log.info( "Low disk space, less than {}", freediskspace );
//    }
  }

  @ShellMethod( "Display required free disk space" )
  public long minimumFreeDiskSpace() {  // minimum-free-disk-space
    return date4uProperties.getFilesystem().getMinimumFreeDiskSpace();
  }

  @ShellMethod( "Display free disk space" )
  public String freeDiskSpace() {   // free-disk-space
    return DataSize.ofBytes( fs.getFreeDiskSpace() ).toGigabytes() + " GB";
  }

  @ShellMethod( "Display user home" )
  public String userHome() {
    return environment.getProperty( "user.home" );
  }

}
