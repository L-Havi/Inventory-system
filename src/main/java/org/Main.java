package org.myapp;

import org.flywaydb.core.Flyway;

//Build the jar-file by running command in shell:
//mvn clean compile package

//run the application
//java -jar target/dbapplication-1.jar

public class Main {

  public static void main(String[] args) {
    try {
      InputScannerApp app = new InputScannerApp();
      doMigrations();
      System.out.println("database is migrated");
      app.startApp(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Virhe.");
    }
  }

  /**
   * Database username and password are configurable information. They are not
   * protected by compilation to bytecode. Repl.it provides a store for these. If
   * you run this application in your Netbeans. You need to configure your own
   * credentials there.
   **/

  public static void doMigrations() {
    String userName = System.getenv("dbusername");
    String password = System.getenv("dbpassword");

    Flyway flyway = Flyway.configure().dataSource("jdbc:sqlite:pm", userName, password).locations("db/migration")
        .load();

    flyway.migrate();
  }

}