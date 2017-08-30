# PhotoBrowse
图片浏览库，单张/多张网络图片，单张/多张资源图片，基于PhotoView，Glide开源框架整合，支持缩放，单点退出，后续升级更多功能！

[![](https://jitpack.io/v/Beseting/PhotoBrowse.svg)](https://jitpack.io/#Beseting/PhotoBrowse)

## Demo

![PhotoBrowse](https://github.com/Beseting/PhotoBrowse/blob/master/app/src/main/res/raw/preview.png "Preview")  

## Download

### #gradle:

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:


	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
#### Step 2. Add the dependency

	dependencies {
	        compile 'com.github.Beseting:PhotoBrowse:v1.0'
	}
	
### #maven:

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
#### Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
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
