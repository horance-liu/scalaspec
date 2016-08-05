Cup(C++ Unified Package) is a management tool with a focus on package dependency automation.

## Install JDK

- Download JDK

```bash
http://www.oracle.com/technetwork/java/javase/downloads/index.html
```

- Install JDK

```bash
$ sudo mkdir -p /usr/local/lib/jvm
$ sudo tar zxvf jdk-8u91-linux-x64.tar.gz -C /usr/local/lib/jvm
$ cd /usr/local/lib/jvm && sudo ln -s jdk1.8.0_91 default
```

- Export `JAVA_HOME` and `PATH`

```bash
$ echo "export JAVA_HOME=/usr/local/lib/java/default" >> ~/.bashrc
$ echo "export PATH=$JAVA_HOME/bin:$PATH" >> ~/.bashrc
$ source ~/.bashrc
```

- Verify

```bash
$ java -version
```

## Building

```bash
$ git clone git@github.com:ccock/cup.git && cd cup
$ ./gradlew spec
```

## IDE Support

This will generate appropriate IDEA metadata so that the project can be opened from within IDEA. 

```bash
$ ./gradlew idea
```
