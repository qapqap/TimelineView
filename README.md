# Customizable Timeline View for Android
Customizable Timeline View for Android, Create a simple timeline list with few lines of code. You can adjust the image, image size, line color, line size, background to the image and the background size.

![](Screenshot.png)

# Download
Add it in your root `build.gradle` at the end of repositories:

``` groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:

``` groovy
dependencies {
    compile 'com.github.qapqap:TimelineView:v1.6'
}
```

# Usage

In your activity java class:
``` java
// Create Timeline rows List
ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();

// Create new timeline row (Row Id)
TimelineRow myRow = new TimelineRow(0);

// To set the row Date (optional)
myRow.setDate(new Date());
// To set the row Title (optional)
myRow.setTitle("Title");
// To set the row Description (optional)
myRow.setDescription("Description");
// To set the row bitmap image (optional)
myRow.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
// To set row Below Line Color (optional)
myRow.setBellowLineColor(Color.argb(255, 0, 0, 0));
// To set row Below Line Size in dp (optional)
myRow.setBellowLineSize(6);
// To set row Image Size in dp (optional)
myRow.setImageSize(40);
// To set background color of the row image (optional)
myRow.setBackgroundColor(Color.argb(255, 0, 0, 0));
// To set the Background Size of the row image in dp (optional)
myRow.setBackgroundSize(60);
// To set row Date text color (optional)
myRow.setDateColor(Color.argb(255, 0, 0, 0));
// To set row Title text color (optional)
myRow.setTitleColor(Color.argb(255, 0, 0, 0));
// To set row Description text color (optional)
myRow.setDescriptionColor(Color.argb(255, 0, 0, 0));

// Add the new row to the list
timelineRowsList.add(myRow);

// Create the Timeline Adapter
ArrayAdapter<TimelineRow> myAdapter = new TimelineViewAdapter(this, 0, timelineRowsList,
	//if true, list will be sorted by date
	false);

// Get the ListView and Bind it with the Timeline Adapter
ListView myListView = (ListView) findViewById(R.id.timeline_listView);
myListView.setAdapter(myAdapter);
```

In your activity layout xml
``` xml
<ListView
    android:id="@+id/timeline_listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:divider="@null"
    android:dividerHeight="0dp" />
```

License
--------

    Copyright 2016 Abdullah Alsulaiman.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
