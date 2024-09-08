# invidious-wrapper
<img src="https://img.shields.io/badge/jdk-8-blue.svg" alt="JDK" />
<img src="https://img.shields.io/github/v/release/yajuhua/invidious-wrapper" alt="Release" />
<img src="https://github.com/yajuhua/invidious-wrapper/actions/workflows/test.yml/badge.svg" alt="test" />

## Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>io.github.yajuhua</groupId>
    <artifactId>invidious-wrapper</artifactId>
    <version>${version}</version>
</dependency>
```
## Usage
#### Init
```java
//Setting up a proxy
Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(10809));
Invidious.proxy = proxy;
```
#### Channel
```java
String id = "UCfX769yHKr7S8gz7UigOsbg";
ChannelDTO channel = Channel.get(id);
```
#### Playlist
```java
String id = "PL4URKQHTymln_XUnkjGqmn9cjEPrQFMNW";
PlaylistDTO playlistDTO = Playlist.get(id);
```
#### Streams
```java
String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
StreamsDTO streamsDTO = Streams.get(id);
```
#### Videos
```java
String id = "UCAr4MVsPBKjhg5eLDDpbDFg";
VideosDTO videosDTO = Videos.get(id);
```
#### Video
```java
String videoId = "oXaxcSBRWVA";
VideoDetailDTO videoDetailDTO = Video.get(videoId);
```

#### Search
```java
String username = "@laogao";
List<SearchDTO> searchDTOS = Search.get(userName);
```
