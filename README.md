<h1>Android SharedPreference Example</h1>

<h3>Add to shared preferences</h3>

```java
SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("example","String to save");
editor.commit();
```

<h3>Read from shared preferences</h3>

```java
SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
String savedArray = sharedPreferences.getString("example","[]");
```
