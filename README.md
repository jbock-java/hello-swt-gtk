### SWT Hello World

Apparently you need to download a jar file and add it to lib folder.
That's just how it's done in the big 2025.

SWT repo: [eclipse github](https://github.com/eclipse-platform/eclipse.platform.swt)

Find the download link and download "SWT Binary and Source" for your platform.
Extract this zip file and copy `swt.jar` to `lib/swt-PLATFORM.jar`,
where `PLATFORM` is `cocoa`, `win32` or `gtk`, depending on your OS.

Now you can run the HelloWorld application:

```sh
./gradlew run
```

