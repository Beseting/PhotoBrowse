# PhotoBrowse
图片浏览库，单张/多张网络图片，单张/多张资源图片，单张/多张Uri图片，基于PhotoView，Glide开源框架整合，支持缩放，单点退出，事件回调，标题内容配置等，后续升级更多功能！

[![](https://jitpack.io/v/Beseting/PhotoBrowse.svg)](https://jitpack.io/#Beseting/PhotoBrowse)

## Demo

![PhotoBrowse](https://github.com/Beseting/PhotoBrowse/blob/master/app/src/main/res/raw/preview.png "Preview")  

## 留下你们的小❤❤吧↑↑↑

<br />

### gradle:

#### 1.在项目的build.gradle中

    allprojects {
        repositories {
        	...
			maven { url 'https://jitpack.io' }
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
	    <version>{ LAST-VERSION }</version>
	</dependency>


## Use

#### 预览类型ShowType（必传）

    SINGLE_URL,//单个Url网络图片预览模式
    MULTIPLE_URL,//多个Url网络图片预览模式
    SINGLE_RES,//单个Res资源图片预览模式
    MULTIPLE_RES,//多个Res网络图片预览模式
    SINGLE_URI,//单个Uri预览模式
    MULTIPLE_URI//多个Uri网络图片预览模式

#### 单张网络图片

	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.SINGLE_URL)
                        .title("xxx")//选传，不配置则不显示
                        .url("xxx")
                        .show();


#### 多张网络图片（可配置事件回调）

	List<String> imageList = new ArrayList<>();
	imageList.add("...");
	...
	List<String> titleList = new ArrayList();
	titleList.add("...");
	...
	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.MULTIPLE_URL)
                        .url(imageList)
                        .title(titleList)//选传，不配置则不显示
                        .position(2)//初始预览位置 默认0
                        .callback(new ClickCallback() {
                            @Override
                            public void onClick(Activity activity, String url, int position) {
                                super.onClick(activity, url, position);
                                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongClick(Activity activity, String url, int position) {
                                super.onLongClick(activity, url, position);
                                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_LONG).show();
                            }
                        })//点击事件回调，默认点击退出
                        .show();

#### 单张资源图片

	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.SINGLE_RES)
                        .res(R.mipmap.xxx)
                        .show();

#### 多张资源图片

	List<Integer> imageResList = new ArrayList<>();
	imageResList.add(R.mipmap.xxx);
	...
	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.MULTIPLE_RES)
                        .res(imageResList)
                        .show();

#### 单张Uri图片

	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.SINGLE_URI)
                        .uri(uri)
                        .show();

#### 多张资源图片

	List<Uri> imageUriList = new ArrayList<>();
	imageUriList.add(mUri);
	...
	PhotoBrowse.with(MainActivity.this)
                        .showType(ShowType.MULTIPLE_URI)
                        .uri(imageUriList)
                        .show();