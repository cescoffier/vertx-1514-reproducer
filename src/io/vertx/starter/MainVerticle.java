package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {
    System.out.println("DISABLE_FILE_CACHING_PROP_NAME: " +
      System.getProperty("vertx.disableFileCaching"));

    vertx.createHttpServer()
        .requestHandler(req -> {
          req.response().sendFile("index.html");
        })
        .listen(8080);
  }

}
