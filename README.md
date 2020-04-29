# PhotoBrowse
图片浏览库，单张/多张网络图片，单张/多张资源图片，单张/多张Uri图片，基于PhotoView，Picasso开源框架整合，支持缩放，单点退出，后续升级更多功能！

[![](https://jitpack.io/v/Beseting/PhotoBrowse.svg)](https://jitpack.io/#Beseting/PhotoBrowse)

## Demo

![PhotoBrowse](https://github.com/Beseting/PhotoBrowse/blob/master/app/src/main/res/raw/preview.png "Preview")  

## 留下你们的小❤❤吧↑↑↑

## Download

使用之前别忘了加上网络请求权限哦 要不然网络图片是加载不出来的<br />

<b>```<uses-permission android:name="android.permission.INTERNET" />```</b>

### gradle:

#### 1.在项目的build.gradle中


    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
			mavenCentral()
        		maven { url 'https://maven.google.com' }
		}
	}

#### 2.添加依赖

	dependencies {
	        implementation 'com.github.Beseting:PhotoBrowse:v{ LAST-VERSION }'
	}

### maven:

#### 1.添加maven仓库

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

#### 2.添加依赖

	<dependency>
	    <groupId>com.github.Beseting</groupId>
	    <artifactId>PhotoBrowse</artifactId>
	    <version>v1.3</version>
	</dependency>


## Use

#### 单张网络图片

	ImageBrowseIntent.showUrlImageBrowse(mContext,"...");

#### 多张网络图片

	List<String> imageList = new ArrayList<>();
	imageList.add("...");
	...
	ImageBrowseIntent.showUrlImageBrowse(mContext,imageList,position);

#### 单张资源图片

	ImageBrowseIntent.showResIdImageBrowse(mContext,R.mipmap.xxx);

#### 多张资源图片

	List<Integer> imageResList = new ArrayList<>();
	imageResList.add(R.mipmap.xxx);
	...
	ImageBrowseIntent.showResIdImageBrowse(mContext,imageResList,position);

#### 单张Uri图片

	ImageBrowseIntent.showUriImageBrowse(mContext,imageUri,position);

#### 多张资源图片

	List<Uri> imageUriList = new ArrayList<>();
	imageUriList.add(mUri);
	...
	ImageBrowseIntent.showUriImageBrowse(mContext,imageUriList,position);