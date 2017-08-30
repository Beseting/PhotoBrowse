# PhotoBrowse
图片浏览库，单张/多张网络图片，单张/多张资源图片，基于PhotoView，Glide开源框架整合，支持缩放，单点退出，后续升级更多功能！

[![](https://jitpack.io/v/Beseting/PhotoBrowse.svg)](https://jitpack.io/#Beseting/PhotoBrowse)

## Demo

![PhotoBrowse](https://github.com/Beseting/PhotoBrowse/blob/master/app/src/main/res/raw/preview.png "Preview")  

## Download

使用之前别忘了加上网络请求权限哦 要不然网络图片是加载不出来的<br />

<b>```<uses-permission android:name="android.permission.INTERNET" />```</b>

### #gradle:

     1.在项目的build.gradle中


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
     2.添加依赖

	dependencies {
	        compile 'com.github.Beseting:PhotoBrowse:v1.0'
	}
	
### #maven:
     1.maven仓库
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
     2.添加依赖

	<dependency>
	    <groupId>com.github.Beseting</groupId>
	    <artifactId>PhotoBrowse</artifactId>
	    <version>v1.0</version>
	</dependency>

	
## Use

#### #单张网络图片

	ImageBrowseIntent.showUrlImageBrowse(mContext,"...");
	
#### #多张网络图片

	ArrayList<String> imageList = new ArrayList<>();
	imageList.add("...");
	...
	ImageBrowseIntent.showUrlImageBrowse(mContext,imageList,position);
	
#### #单张资源图片

	ImageBrowseIntent.showResIdImageBrowse(mContext,R.mipmap.xxx);
	
#### #多张资源图片

	ArrayList<Integer> imageResList = new ArrayList<>();
	imageResList.add(R.mipmap.xxx);
	...
	ImageBrowseIntent.showResIdImageBrowse(mContext,imageResList,position);
