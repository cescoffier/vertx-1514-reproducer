# vertx-1514-reproducer
An attempt to reproduce https://github.com/eclipse/vert.x/issues/1514

## Test in redeploy mode

Start the application with:

```
./vertx.sh run src/io/vertx/starter/MainVerticle.java --redeploy="src/**/*.java" -Dvertx.disableFileCaching=true --launcher-class="io.vertx.core.Launcher" -cp webroot
```

In another terminal, launch:

```
curl http://localhost:8080
```

Edit the `webroot/index.html` file and re-execute the curl command. The served file should contained the updates.

## Test with start

```
./vertx.sh start run src/io/vertx/starter/MainVerticle.java -Dvertx.disableFileCaching=true --launcher-class="io.vertx.core.Launcher" -cp webroot --redirect-output
```

## Some explanations

The `index.html` file is served from the classpath. By disabling the file cache, the file is already reloaded from the source (so the classpath). The file is still copied to the `.vertx` directory.
